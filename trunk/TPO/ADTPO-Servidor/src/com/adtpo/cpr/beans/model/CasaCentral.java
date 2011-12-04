package com.adtpo.cpr.beans.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.adtpo.cpr.bean.dao.CprDAO;
import com.adtpo.cpr.bean.dao.OficinaVentaDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.hql.ConsultasHQL;

public class CasaCentral {
	
	private static CasaCentral instancia;
	
	private ArrayList<Proveedor> proveedores;
	
	/**
	 * Lista creada al iniciar el sistema, generada en funcion de las listas
	 * de rodamientos guardadas en la base de datos.
	 */	
	private ArrayList<Rodamiento> rodamientosUnicos;
	
	private ArrayList<Venta> ventas;
	private ArrayList<OrdenDeCompra> ordenesDeCompra;
	
	/**
	 * Lista completada con la tabla ListasProveedor de la base de datos
	 * consultada al iniciar el sistema.
	 */
	private ArrayList<ListasProveedor> listadoListaDeProveedores;
	
	/**
	 * Lista creada al iniciar el sistema, generada en funcion de listasProveedores
	 * y rodamientos creando una comparativa de precios de cada rodamiento.
	 */
	
	private Map<Date, ListasProveedor> listaComparativa;
	private ArrayList<Cotizacion> cotizaciones;
	
	
	public CasaCentral(){
		proveedores = new ArrayList<Proveedor>();
		rodamientosUnicos = new ArrayList<Rodamiento>();
		ventas = new ArrayList<Venta>();
		ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		cotizaciones = new ArrayList<Cotizacion>();
		listaComparativa = new HashMap<Date, ListasProveedor>();
		
	}
	
	public static CasaCentral getInstancia() {
		if (instancia == null) {
			instancia = new CasaCentral();
		}
		return instancia;
	}

	public void agregarProveedor(Proveedor proveedor) {
		proveedores.add(proveedor);
		CprDAO.getInstancia().grabarProveedor(proveedor);		
	}

	public void eliminarProveedor(Proveedor proveedor) throws DataBaseInvalidDataException{
		if(proveedor.getIdProveedor()>0){
			if(getProveedor(proveedor)!=null){
				proveedores.remove(proveedor);
				CprDAO.getInstancia().eliminarProveedor(proveedor);
			}else
				throw new DataBaseInvalidDataException();
		}else{
			if(buscarProveedorPorCuit(proveedor.getCuit())!=null){
				CprDAO.getInstancia().eliminarProveedorPorCuit(proveedor.getCuit());
			}else
				throw new DataBaseInvalidDataException();
		}
	}

	private Proveedor buscarProveedorPorCuit(String cuit){
		Proveedor prove = null;
		for(Proveedor p: proveedores)
			if(p.getCuit().equals(cuit))
				prove = p;
		if(prove == null)
			prove = CprDAO.getInstancia().getProveedorPorCuit(cuit);
		return prove;
	}

	public Proveedor getProveedor(Proveedor prove) throws DataBaseInvalidDataException {
		for(Proveedor p: proveedores)
			if(p.equals(prove))
				return p;
		return CprDAO.getInstancia().getProveedor(prove);
	}

	public float getPorcentajeGanancia() {
		PorcentajeGanancia pg = new PorcentajeGanancia();
		float porc = pg.getPorcentaje();
		if(porc<=0)
			return -1;
		return porc;
	}
	
	public void agregarRodamiento(Rodamiento rod){
		rodamientosUnicos.add(rod);
		CprDAO.getInstancia().grabarRodamiento(rod);
	}
	
	public void setPorcentajeGanancia(float porcentaje) {
		CprDAO.getInstancia().setPorcentajeGanancia(porcentaje);
	}

	public void inicializarPorcentajeGanancia() {
		if(getPorcentajeGanancia() == -1){
			PorcentajeGanancia pg = new PorcentajeGanancia();
			pg.setNombre("Porcentaje de ganancia");
			pg.setPorcentaje((float) 0.15);
			CprDAO.getInstancia().inicializarPorcentajeGanancia(pg);
		}
	}

	public ArrayList<ListasProveedor> getListasProveedor(int idProveedor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Actualiza la lista de rodamientos unicos en base al listado de las listas de proveedores (la cual 
	 * se actualiza con la base de datos)
	 * 
	 */
	
	public void actualizarListaRodamientosUnicos(){
		for(ListasProveedor lp : listadoListaDeProveedores){
			for(Rodamiento rod : lp.getListaRodamientos().keySet()){
				if(!rodamientosUnicos.contains(rod))
					rodamientosUnicos.add(rod);
			}
		}
	}
	
	/**
	 * Metodo utilizado por el servicio remoto para consultar la lista comparativa desde 
	 * las vistas.
	 * 
	 * @return un objeto ListasProveedor con todos los datos de la lista.
	 */
	
	public ListasProveedor getListaComparativa(){
		if(!listaComparativa.containsKey(Calendar.getInstance().getTime()))
			generarListaComparativa();
		return listaComparativa.get(Calendar.getInstance().getTime());
	}
	
	/**
	 * Todos los dias el sistema genera una nueva lista comparativa (hasta 30 dias) 
	 * para estar actualizado y tambien tener precios anteriores. Para esto, mira su lista
	 * de rodamientos unicos y le cotiza el mejor precio a cada uno, agregandolo a la lista.
	 * 
	 */
	
	public void generarListaComparativa(){
		if (!listaComparativa.containsKey(Calendar.getInstance().getTime())) {
			ListasProveedor listaHoy = new ListasProveedor();
			listaHoy.setListaRodamientos(new HashMap<Rodamiento, Float>());
			for (Rodamiento rodTemp : rodamientosUnicos) {
				Object[] rodamientoCotizado = cotizarRodamiento(rodTemp);
				ItemRodamiento item = (ItemRodamiento) rodamientoCotizado[0];
				ListasProveedor lista = (ListasProveedor) rodamientoCotizado[1];
				listaHoy.setIdLista(lista.getIdLista());
				listaHoy.setNombre(lista.getNombre());
				listaHoy.setProveedor(lista.getProveedor());
				listaHoy.getListaRodamientos().put(rodTemp, new Float(item.getPrecio()));
			}
		}
	}
	
	
	
	
	/**
	 * Cotizar un rodamiento calculando el precio minimo de todas las listas de proveedores
	 * existentes. Este metodo se utiliza principalmente para generar la lista comparativa
	 * pero tambien se puede usar para calcular el precio minimo de un rodamiento especifico.
	 * 
	 * 
	 * @param rodamiento
	 * @return Un mapa con ItemRodamiento, ListasProveedor para poder publicarla en la lista
	 * comparativa con toda la informacion necesaria
	 * 
	 * @return **NUEVO** Un array de Objectos con 2 datos, en la posicion 0 el ItemRodamiento, con el precio
	 * minimo calculado, y en la posicion 1 la lista del proveedor con todos los datos para tener en 
	 * la lista comparativa.
	 * 
	 */
	
	public Object[] cotizarRodamiento(Rodamiento rodamiento){
		Object[] datos = new Object[2];
//		HashMap<ItemRodamiento, ListasProveedor> mapa = new HashMap<ItemRodamiento, ListasProveedor>();
		ItemRodamiento itemCotizado = new ItemRodamiento();
		itemCotizado.setRodamiento(rodamiento);

		float precioMinimo = 0;
		ListasProveedor listaEncontrada = null;
		for(ListasProveedor listaTemp : listadoListaDeProveedores){
			float precioLista = listaTemp.calcularPrecioMinimo(rodamiento);
			if(precioMinimo > precioLista){
				precioMinimo = precioLista;
				listaEncontrada = listaTemp;
				listaEncontrada.setListaRodamientos(null);
			}
		}
		itemCotizado.setPrecio(precioMinimo);
		itemCotizado.setProveedor(listaEncontrada.getProveedor());
		datos[0] = itemCotizado;
		datos[1] = listaEncontrada;
//		mapa.put(itemCotizado, listaEncontrada);
		return datos;
	}
	
	/**
	 * Evalua si el rodamiento pasado por parametro existe en la lista de rodamientos unicos
	 * generada con el proposito de tener todos los rodamientos que la empresa comercializa
	 * sin tener que mirar cada lista de proveedor.
	 * 
	 * @param rod
	 * @return true si existe el rodamiento, false si no existe.
	 */
	
	public boolean isRodamientoUnicoListado(Rodamiento rod){
		for(Rodamiento r: rodamientosUnicos)
			if(rod.equals(r))
				return true;
		return false;
	}
	
	/**
	 * 
	 * Devuelve el rodamiento en la lista de rodamientos unicos, comparando sus 3 claves.
	 * 
	 * @param codigo
	 * @param marca
	 * @param pais
	 * @return rodamiento si existe, null si no existe
	 */
	
	private Rodamiento buscarRodamientoUnico(String codigo, String marca, String pais){
		Rodamiento r = null;
//		for(r: rodamientos)
//			if()
		return r;
	}

	@SuppressWarnings("static-access")
	public void inicializarListasProveedores() {
		rodamientosUnicos = (ArrayList<Rodamiento>) CprDAO.getInstancia().getListaEntidades(Rodamiento.class);
	}
	
	/**
	 * Metodo que procesa la solicitud de venta al momento en que el cliente ingresa su id, 
	 * y los rodamientos que quiere comprar. El sistema busca los items pedidos en las cotizaciones
	 * activas del cliente y si una cotizacion coincide, la asocia y genera la venta y devuelve
	 * la factura (esto estamos viendolo). Si no coincide se genera una nueva solicitud de 
	 * cotizacion y se envia al cliente para confirmacion.
	 * 
	 * @param rodamientos
	 * @param clienteId
	 * @throws DataBaseInvalidDataException 
	 */
	
	public Venta procesarSolicitudVenta (ArrayList<ItemRodamiento> rodamientos, int clienteId) throws DataBaseInvalidDataException{
		Venta v = new Venta();
		for(Cotizacion cot : cotizaciones){
			if(cot.getCliente().getIdCliente() == clienteId){
				ArrayList<ItemRodamiento> temp = cot.getItems();
				ArrayList<ItemRodamiento> input = rodamientos;
				while (!temp.isEmpty() && !input.isEmpty()){
					for(ItemRodamiento itemSolicitud : input){
						for(ItemRodamiento itemCotizacion : temp){
							if(itemSolicitud.equals(itemCotizacion) 
									&& (itemSolicitud.getCantidad() == itemCotizacion.getCantidad())){
								input.remove(itemSolicitud);
								temp.remove(itemCotizacion);	
							}
						}
					}
				}
				if (temp.isEmpty()){
					OficinaVentas.getInstancia().generarCotizacion(clienteId, input);
					Venta vta = new Venta();
					vta.setCotizacion(cot);
					
					v=vta;
				}
				if (input.isEmpty()){
					OficinaVentas.getInstancia().generarCotizacion(clienteId, rodamientos);
				}
				if (input.isEmpty() && temp.isEmpty()){
					Venta vta = new Venta();
					vta.setCotizacion(cot);
		
					v=vta;
				}
				
			}
		}
		
		return v;
	}

	public ArrayList<ItemRodamiento> cotizarItemsSolicitud(
			ArrayList<ItemRodamiento> items) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
