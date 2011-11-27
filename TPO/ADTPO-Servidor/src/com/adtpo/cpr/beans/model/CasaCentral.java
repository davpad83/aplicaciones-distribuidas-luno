package com.adtpo.cpr.beans.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.adtpo.cpr.bean.dao.CprDAO;

public class CasaCentral {
	
	private static CasaCentral instancia;
	
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Rodamiento> rodamientos;
	private ArrayList<Venta> ventas;
	private ArrayList<OrdenDeCompra> ordenesDeCompra;
	private Map<Date, Lista> listaComparativa;
	private ArrayList<Cotizacion> cotizaciones;
	
	
	public CasaCentral(){
		proveedores = new ArrayList<Proveedor>();
		rodamientos = new ArrayList<Rodamiento>();
		ventas = new ArrayList<Venta>();
		ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		cotizaciones = new ArrayList<Cotizacion>();
		listaComparativa = new HashMap<Date, Lista>();
		
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

	public void eliminarProveedor(Proveedor proveedor) {
		proveedores.remove(proveedor);
		CprDAO.getInstancia().eliminarProveedor(proveedor);
	}
	
	

}
