package com.adtpo.cpr.beans.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.jtds.jdbc.DateTime;

import com.adtpo.cpr.bean.dao.CprDAO;
import com.adtpo.cpr.bean.dao.OficinaVentaDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CotizacionBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.hql.ConsultasHQL;

public class CasaCentral {

	private static CasaCentral instancia;

	private ArrayList<Proveedor> proveedores;

	/**
	 * Lista creada al iniciar el sistema, generada en funcion de las listas de
	 * rodamientos guardadas en la base de datos.
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
	 * Lista creada al iniciar el sistema, generada en funcion de
	 * listasProveedores y rodamientos creando una comparativa de precios de
	 * cada rodamiento.
	 */

	private ArrayList<ListaComparativa> listaComparativa;
	private ArrayList<Cotizacion> cotizaciones;

	// ///////////////////////////////////////////////////////
	// ////////CASA CENTRAL
	// ///////////////////////////////////////////////////////
	public CasaCentral() {
		proveedores = new ArrayList<Proveedor>();
		rodamientosUnicos = new ArrayList<Rodamiento>();
		ventas = new ArrayList<Venta>();
		ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		cotizaciones = new ArrayList<Cotizacion>();
		listaComparativa = new ArrayList<ListaComparativa>();
		listadoListaDeProveedores = new ArrayList<ListasProveedor>();
		rodamientosUnicos = new ArrayList<Rodamiento>();
	}

	public static CasaCentral getInstancia() {
		if (instancia == null) {
			instancia = new CasaCentral();
		}
		return instancia;
	}

	// ///////////////////////////////////////////////////////
	// ////////PROVEEDOR
	// ///////////////////////////////////////////////////////

	public void agregarProveedor(Proveedor proveedor) throws DataBaseInvalidDataException {
		if(!existeProveedor(proveedor)) {
			proveedores.add(proveedor);
			CprDAO.getInstancia().grabarProveedor(proveedor);		
		}
	}

	public void modificarProveedor(Proveedor proveedor)
			throws DataBaseInvalidDataException {
		if (existeProveedor(proveedor)) {
			CprDAO.getInstancia().grabarProveedor(proveedor);
			proveedores.remove(proveedor);
			proveedores.add(proveedor);
		}
	}

	public void eliminarProveedor(Proveedor proveedor)
			throws DataBaseInvalidDataException {
		if(existeProveedor(proveedor)){
			if (proveedor.getIdProveedor() > 0) {
				if (getProveedor(proveedor) != null) {
					proveedores.remove(proveedor);
					CprDAO.getInstancia().eliminarProveedor(proveedor);
				} else
					throw new DataBaseInvalidDataException();
			} else {
				if (getProveedorPorCuit(proveedor.getCuit()) != null) {
					CprDAO.getInstancia().eliminarProveedorPorCuit(
							proveedor.getCuit());
				} else
					throw new DataBaseInvalidDataException();
			}
		}
	}

	private Proveedor getProveedorPorCuit(String cuit) {
		Proveedor prove = null;
		for (Proveedor p : proveedores)
			if (p.getCuit().equals(cuit))
				prove = p;
		if (prove == null)
			prove = CprDAO.getInstancia().getProveedorPorCuit(cuit);
		return prove;
	}

	public Proveedor getProveedor(Proveedor prove)
			throws DataBaseInvalidDataException {
		Proveedor pEncontrado = null;
		for (Proveedor p : proveedores)
			if (p.equals(prove))
				pEncontrado = p;
		if(pEncontrado == null)
			pEncontrado = CprDAO.getInstancia().getProveedor(prove);
		return pEncontrado;
	}

	private boolean existeProveedor(Proveedor proveedor){
		if(proveedor.getIdProveedor() <= 0){
			if(proveedor.getCuit() !=null && !proveedor.getCuit().isEmpty()){
				for(Proveedor p : proveedores){
					if(proveedor.getCuit().equals(p.getCuit()))
						return true;
				}
			}
		}else{
			for(Proveedor p : proveedores){
				if(proveedor.getIdProveedor() == p.getIdProveedor())
					return true;
			}
		}
		return CprDAO.getInstancia().existeProveedor(proveedor);
	}
	
	public ArrayList<ListasProveedor> getListasProveedor(int idProveedor) {
		// TODO getListasProveedor
		return null;
	}

	public void agregarListaProveedor(ListasProveedor listaProveedor) {
		CprDAO.getInstancia().grabarListaProveedor(listaProveedor);
	}
	
	private boolean existenListasProveedores(){
		if(listadoListaDeProveedores != null && !listadoListaDeProveedores.isEmpty())
			return true;
		return CprDAO.getInstancia().existenListasProveedores();
	}

	public void agregarMapaRodamientoPrecio(MapaRodamientoPrecio mrp){
		CprDAO.getInstancia().agregarMapaRodamientoPrecio(mrp);
	}
	
	public void agregarMapaRodamientoPrecioList(List<MapaRodamientoPrecio> list){
		for(MapaRodamientoPrecio mrpItem: list){
			agregarMapaRodamientoPrecio(mrpItem);
		}
	}
	
	public MapaRodamientoPrecio getMapaRodamientoPrecio(MapaRodamientoPrecio mrp){
		return CprDAO.getInstancia().getMapaRodamientoPrecio(mrp);
	}
	
	public List<MapaRodamientoPrecio> getMapaRodamientoPrecioList(List<MapaRodamientoPrecio> list){
		for(MapaRodamientoPrecio mrpItem: list){
			mrpItem = getMapaRodamientoPrecio(mrpItem);
		}
		return list;
	}
	
	// ///////////////////////////////////////////////////////
	// ////////STOCK DE RODAMIENTO
	// ///////////////////////////////////////////////////////

	private void registrarMovimientoStock(Rodamiento rod, double cantidad,
			int saldo) {
		MovimientosStock ms = new MovimientosStock();
		ms.registrarFecha();
		ms.setRodamiento(rod);
		ms.setSaldoCantidad(saldo);
		if (cantidad > 0)
			ms.setDetalle("Stock agregado");
		else
			ms.setDetalle("Stock disminuido");
		CprDAO.getInstancia().registrarMovimientoStock(ms);
	}

	public void agregarStockRodamiento(Rodamiento rod, int cantidad) {
		ItemListaComparativa rodCotizado = cotizarRodamiento(rod);

		// TODO agregarStockRodamiento
	}

	public void eliminarStockRodamiento(Rodamiento rod, int cantidad) {
		// TODO eliminarStockRodamiento
	}

	// ///////////////////////////////////////////////////////
	// ////////PORCENTAJE DE GANANCIA
	// ///////////////////////////////////////////////////////

	public float getPorcentajeGanancia() {
		PorcentajeGanancia pg = new PorcentajeGanancia();
		float porc = pg.getPorcentaje();
		if (porc <= 0)
			return -1;
		return porc;
	}

	/**
	 * Reemplaza el porcentaje de ganancia existente por el enviado por
	 * parametro
	 * 
	 * @param porcentaje
	 */

	public void setPorcentajeGanancia(float porcentaje) {
		CprDAO.getInstancia().setPorcentajeGanancia(porcentaje);
	}

	/**
	 * Busca si el porcentaje de ganancia ya esta configurado en la base de
	 * datos.
	 * 
	 * Si lo esta, no hace nada. Si no lo esta, lo agrega y lo configura con su
	 * valor por default.
	 * 
	 * @param no
	 *            parameters
	 * @return void
	 */

	public void inicializarPorcentajeGanancia() {
		if (getPorcentajeGanancia() <= 0) {
			PorcentajeGanancia pg = new PorcentajeGanancia();
			pg.setNombre("Porcentaje de ganancia");
			pg.setPorcentaje((float) 0.15);
			CprDAO.getInstancia().inicializarPorcentajeGanancia(pg);
		}
	}

	// ///////////////////////////////////////////////////////
	// ////////RODAMIENTOS
	// ///////////////////////////////////////////////////////

	/**
	 * Actualiza la lista de rodamientos unicos 
	 * 
	 * @return void
	 * 
	 */

	public void actualizarListaRodamientosUnicos() {
		rodamientosUnicos = CprDAO.getInstancia()
				.getRodamientos();
	}

	/**
	 * Evalua si el rodamiento pasado por parametro existe en la lista de
	 * rodamientos unicos generada con el proposito de tener todos los
	 * rodamientos que la empresa comercializa sin tener que mirar cada lista de
	 * proveedor.
	 * 
	 * @param rod
	 * @return true si existe el rodamiento, false si no existe.
	 */

	public boolean isRodamientoUnicoListado(Rodamiento rod) {
		for (Rodamiento r : rodamientosUnicos)
			if (rod.equals(r))
				return true;
		return false;
	}

	/**
	 * 
	 * Devuelve el rodamiento en la lista de rodamientos unicos, comparando sus
	 * 4 claves.
	 * 
	 * @param codigo
	 * @param marca
	 * @param pais
	 * @return rodamiento si existe, null si no existe
	 */

	private Rodamiento buscarRodamientoUnico(String codigo, String marca,
			String caracteristica, String pais) {
		// TODO corregir buscarRodamientoUnico
		Rodamiento r = null;
		// for(r: rodamientos)
		// if()
		return r;
	}

	// ///////////////////////////////////////////////////////
	// ////////LISTA COMPARATIVA
	// ///////////////////////////////////////////////////////

	/**
	 * Metodo utilizado por el servicio remoto para consultar la lista
	 * comparativa. Controla si la ultima lista comparativa es del dia actual.
	 * 
	 * Si lo es, la devuelve. Si no lo es, llama al metodo
	 * generarListaComparativa() y luego la devuelve.
	 * 
	 * @return un objeto ListaComparativa con todos los datos de la lista.
	 */

	public ListaComparativa getListaComparativa() {
		if (!existeListaComparativaHoy())
			generarListaComparativa();
		levantarListasComparativas();
		ListaComparativa returnList = null;
		for (ListaComparativa list : listaComparativa) {
			if (isMismoDia(list.getFechaLista(), new Date()))
				returnList = list;
		}
		return returnList;
	}
	
	/**
	 * Metodo utilizado por el servicio remoto para consultar la lista
	 * comparativa. Devuelve la lista comparativa especificada por la fecha
	 * enviada. Si no existe una lista comparativa en esa fecha devuelve null.
	 * 
	 * @return un objeto ListaComparativa con todos los datos de la lista.
	 */

	public ListaComparativa getListaComparativaFecha(Date fecha) {
		ListaComparativa returnList = null;
		
		for (ListaComparativa list : listaComparativa) {
			if (isMismoDia(list.getFechaLista(), fecha))
				returnList = list;
		}
		if(returnList == null)
			returnList = CprDAO.getInstancia().getListaComparativa();
		return returnList;
	}

	/**
	 * Mira todas las listas comparativas creadas en el sistema y en la base de
	 * datos y retorna la fecha con un Date con la fecha de la lista mas actual.
	 * 
	 * @return Date con la fecha de la ultima lista comparativa registrada
	 */

	public boolean existeListaComparativaHoy() {
		levantarListasComparativas();
		if (!listaComparativa.isEmpty()) {
			for (ListaComparativa lista : listaComparativa) {
				if (isMismoDia(Calendar.getInstance().getTime(), lista
						.getFechaLista()))
					return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Levanta las listas comparativas de la base de datos y las trae a memoria
	 * 
	 */

	public void levantarListasComparativas() {
		listaComparativa = CprDAO.getInstancia().levantarListasComparativas();
	}

	/**
	 * Devuelve la lista comparativa con la fecha mas cercana a la actual.
	 * 
	 * @return ListaComparativa
	 */

	// private ListaComparativa getUltimaListaComparativa() {
	// ListaComparativa ultimaLista = null;
	// for (ListaComparativa lista : listaComparativa) {
	// if (lista.getFechaLista().compareTo(existeListaComparativaHoy()) == 0)
	// ultimaLista = lista;
	// }
	// if (ultimaLista == null)
	// ultimaLista = CprDAO.getInstancia().getUltimaListaComparativa();
	// return ultimaLista;
	// }

	/**
	 * Todos los dias el sistema genera una nueva lista comparativa (hasta 30
	 * dias) para estar actualizado y tambien tener precios anteriores. Para
	 * esto, mira su lista de rodamientos unicos y le cotiza el mejor precio a
	 * cada uno, agregandolo a la lista.
	 * 
	 */

	public void generarListaComparativa() {
		levantarListasComparativas();
		if (existenListasProveedores()) {
			if (!existeListaComparativaHoy()) {
				ListaComparativa listaHoy = new ListaComparativa();
				listaHoy.setFechaLista(Calendar.getInstance().getTime());

				ArrayList<ItemListaComparativa> arrayListaComparativa = new ArrayList<ItemListaComparativa>();
				if(rodamientosUnicos.isEmpty())
					actualizarListaRodamientosUnicos();
				for (Rodamiento rodTemp : rodamientosUnicos) {
					ItemListaComparativa itemNuevo = cotizarRodamiento(rodTemp);
					arrayListaComparativa.add(itemNuevo);
				}
				listaHoy.setItems(arrayListaComparativa);
				CprDAO.getInstancia().guardarListaComparativa(listaHoy);
			}
		}
	}

	// ///////////////////////////////////////////////////////
	// ////////COTIZACIONES
	// ///////////////////////////////////////////////////////

	/**
	 * Cotiza un rodamiento calculando el precio minimo de todas las listas de
	 * proveedores existentes y sumandole el porcentaje de ganancia. Este metodo
	 * se utiliza principalmente para generar la lista comparativa pero tambien
	 * se puede usar para calcular el precio minimo de un rodamiento especifico.
	 * 
	 * @param rodamiento
	 * @return ItemListaComparativa
	 */

	public ItemListaComparativa cotizarRodamiento(Rodamiento rodamiento) {
		ItemListaComparativa ilc = new ItemListaComparativa();

		ilc.setRodamiento(rodamiento);

		ListasProveedor listaEncontrada = null;
		if(listadoListaDeProveedores.isEmpty())
			inicializarListadoDeListasProveedores();
		float precioMinimo = listadoListaDeProveedores.get(0).calcularPrecioMinimo(rodamiento);
		for (ListasProveedor listaTemp : listadoListaDeProveedores) {
			float precioLista = listaTemp.calcularPrecioMinimo(rodamiento);
			if (precioLista != -1 && precioMinimo > precioLista) {
				precioMinimo = precioLista;
				listaEncontrada = listaTemp;
				listaEncontrada.setMapaRodamientoPrecio(null);
			}
		}
		// Aca ya tengo el precio minimo del rodamiento, y le agrego el
		// porcentaje de ganancia
		float porcentajeGanancia = getPorcentajeGanancia();
		if(porcentajeGanancia==-1)
			porcentajeGanancia = (float)0.15;
		
		ilc.setPrecio(precioMinimo + precioMinimo * porcentajeGanancia);
		ilc.setListaProveedor(listaEncontrada);

		return ilc;
	}

	/**
	 * Cotiza un rodamiento con la cantidad enviada calculando el precio minimo
	 * de todas las listas de proveedores existentes y sumandole el porcentaje
	 * de ganancia. Este metodo se utiliza principalmente para generar la lista
	 * comparativa pero tambien se puede usar para calcular el precio minimo de
	 * un rodamiento especifico.
	 * 
	 * @param rodamiento
	 * @return ItemListaComparativa
	 */

	public ItemListaComparativa cotizarRodamiento(Rodamiento rodamiento,
			int cantidad) {
		ItemListaComparativa ilc = new ItemListaComparativa();
		// TODO falta hacer que cotize en funcion de la cantidad
		ilc.setRodamiento(rodamiento);

		float precioMinimo = 0;
		ListasProveedor listaEncontrada = null;
		for (ListasProveedor listaTemp : listadoListaDeProveedores) {
			float precioLista = listaTemp.calcularPrecioMinimo(rodamiento);
			if (precioMinimo > precioLista) {
				precioMinimo = precioLista;
				listaEncontrada = listaTemp;
				listaEncontrada.setMapaRodamientoPrecio(null);
			}
		}
		float porcentajeGanancia = getPorcentajeGanancia();
		if(porcentajeGanancia==-1)
			porcentajeGanancia = (float)0.15;
		
		ilc.setPrecio((precioMinimo + precioMinimo * porcentajeGanancia)*cantidad);
		ilc.setListaProveedor(listaEncontrada);

		return ilc;
	}

	/**
	 * Recibe una lista de ItemRodamiento que tiene un rodamiento y su cantidad
	 * y completa los datos precio y proveedor restantes, correspondientes al
	 * resultado de una cotizacion.
	 * 
	 * @param ArrayList
	 *            <ItemRodamiento>
	 * @return ArrayList<ItemRodamiento>
	 */

	public ArrayList<ItemRodamiento> cotizarItemsSolicitud(ArrayList<ItemRodamiento> items) {
		ArrayList<ItemRodamiento> cotizados = new ArrayList<ItemRodamiento>();
		for (ItemRodamiento itemSolicitud : items) {
			for (ItemListaComparativa itemListaComp : getListaComparativa().getItems()) {
				if (itemSolicitud.getRodamiento().equals(itemListaComp.getRodamiento())) {
					itemSolicitud.setPrecio(itemListaComp.getPrecio());
					itemSolicitud.setProveedor(itemListaComp.getListaProveedor().getProveedor());
					cotizados.add(itemSolicitud);
				}
			}
		}
		return cotizados;
	}

	// ///////////////////////////////////////////////////////
	// ////////PROVEEDORES
	// ///////////////////////////////////////////////////////

	/**
	 * Popula el listado de Rodamientos de los proveedores en memoria
	 */

	public void inicializarListadoDeListasProveedores() {
		listadoListaDeProveedores = (ArrayList<ListasProveedor>) CprDAO
				.getInstancia().getListadoListaDeProveedores();
	}

	// ///////////////////////////////////////////////////////
	// ////////SOLICITUD DE VENTA
	// ///////////////////////////////////////////////////////

	/**
	 * Metodo que procesa la solicitud de venta al momento en que el cliente
	 * ingresa su id, y los rodamientos que quiere comprar. El sistema busca los
	 * items pedidos en las cotizaciones activas del cliente y si una cotizacion
	 * coincide, la asocia y genera la venta y devuelve la factura (esto estamos
	 * viendolo). Si no coincide se genera una nueva solicitud de cotizacion y
	 * se envia al cliente para confirmacion.
	 * 
	 * @param rodamientos
	 * @param clienteId
	 * @throws DataBaseInvalidDataException
	 */

	public Venta procesarSolicitudVenta(ArrayList<ItemRodamiento> rodamientos,
			int clienteId) throws DataBaseInvalidDataException {
		Venta v = new Venta();
		for (Cotizacion cot : cotizaciones) {
			if (cot.getCliente().getIdCliente() == clienteId) {
				List<ItemRodamiento> temp = cot.getItems();
				ArrayList<ItemRodamiento> input = rodamientos;
				while (!temp.isEmpty() && !input.isEmpty()) {
					for (ItemRodamiento itemSolicitud : input) {
						for (ItemRodamiento itemCotizacion : temp) {
							if (itemSolicitud.equals(itemCotizacion)
									&& (itemSolicitud.getCantidad() == itemCotizacion
											.getCantidad())) {
								input.remove(itemSolicitud);
								temp.remove(itemCotizacion);
							}
						}
					}
				}
				if (temp.isEmpty()) {
					OficinaVentas.getInstancia().generarCotizacion(clienteId,
							input);
					Venta vta = new Venta();
					vta.setCotizacion(cot);

					v = vta;
				}
				if (input.isEmpty()) {
					OficinaVentas.getInstancia().generarCotizacion(clienteId,
							rodamientos);
				}
				if (input.isEmpty() && temp.isEmpty()) {
					Venta vta = new Venta();
					vta.setCotizacion(cot);

					v = vta;
				}

			}
		}

		return v;
	}

	private boolean isMismoDia(Date fecha1, Date fecha2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(fecha1);
		cal2.setTime(fecha2);
		boolean mismoDia = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2
						.get(Calendar.DAY_OF_YEAR);
		return mismoDia;
	}

	// ///////////////////////////////////////////////////////
	// ////////ORDEN DE COMPRA
	// ///////////////////////////////////////////////////////
	public void GenerarOrderDeCompra(Proveedor p,
			ArrayList<ItemRodamiento> items) {
		OrdenDeCompra oc = new OrdenDeCompra();
		oc.setFecha(new Date());
		oc.setItems(items);
		oc.setProveedor(p);
		CprDAO.getInstancia();
		CprDAO.almacenaEntidad(oc);
	}

	// ///////////////////////////////////////////////////////
	// ////////POLITICAS
	// ///////////////////////////////////////////////////////

	public void inicializarPoliticas() {
		if (!existePoliticaContado()) {
			PolPagoContado politicaContado = new PolPagoContado();
		}

		if (!existePoliticaVolumen()) {
			PolVolumenVenta politicaVolumen = new PolVolumenVenta();

		}
		if (!existePoliticaCortoPlazo()) {
			PolPagoCortoPlazo politicaCortoPlazo = new PolPagoCortoPlazo();

		}

	}

	private boolean existePoliticaCortoPlazo() {
		// TODO existePoliticaCortoPlazo()
		return false;
	}

	private boolean existePoliticaVolumen() {
		// TODO existePoliticaVolumen
		return false;
	}

	private boolean existePoliticaContado() {
		// TODO existePoliticaContado
		return false;
	}

	public CondicionVenta getCondicionVenta(int idCondicion) {
		return CprDAO.getInstancia().getCondicionVenta(idCondicion);
	}

	public void nuevaCondicionVenta(CondicionVenta condicionVenta) {
		CprDAO.getInstancia().grabarCondicionVenta(condicionVenta);
	}

	public Cotizacion getCotizacion(int idCotizacion) {
		return CprDAO.getInstancia().getCotizacion(idCotizacion);

	}

	public ArrayList<Cotizacion> getCotizacionesCliente(Cliente cli) {
		return CprDAO.getInstancia().getCotizacionesCliente(cli);
	}
}
