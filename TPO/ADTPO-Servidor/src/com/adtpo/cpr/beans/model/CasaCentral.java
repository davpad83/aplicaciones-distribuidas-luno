package com.adtpo.cpr.beans.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.adtpo.cpr.bean.dao.CprDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;

public class CasaCentral {
	
	private static CasaCentral instancia;
	
	private ArrayList<Proveedor> proveedores;
	
	/**
	 * Lista creada al iniciar el sistema, generada en funcion de las listas
	 * de rodamientos guardadas en la base de datos.
	 */	
	private ArrayList<Rodamiento> rodamientos;
	private ArrayList<Venta> ventas;
	private ArrayList<OrdenDeCompra> ordenesDeCompra;
	
	/**
	 * Lista completada con la tabla ListasProveedor de la base de datos
	 * consultada al iniciar el sistema.
	 */
	private ArrayList<ListasProveedor> listasProveedores;
	
	/**
	 * Lista creada al iniciar el sistema, generada en funcion de listasProveedores
	 * y rodamientos creando una comparativa de precios de cada rodamiento.
	 */
	
	private Map<Date, ListasProveedor> listaComparativa;
	private ArrayList<Cotizacion> cotizaciones;
	
	
	public CasaCentral(){
		proveedores = new ArrayList<Proveedor>();
		rodamientos = new ArrayList<Rodamiento>();
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
		PorcentajeGanancia pg = CprDAO.getInstancia().getPorcentajeGanancia();
		if(pg == null)
			return -1;
		return pg.getPorcentaje();
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

	public ArrayList<ListasProveedorBean> getListasProveedor(int idProveedor) {
		// TODO Auto-generated method stub
		return null;
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
		for(Rodamiento r: rodamientos)
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
}
