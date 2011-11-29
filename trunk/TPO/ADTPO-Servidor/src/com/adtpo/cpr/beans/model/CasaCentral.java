package com.adtpo.cpr.beans.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.adtpo.cpr.bean.dao.CprDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;

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

	public void eliminarProveedor(Proveedor proveedor) throws DataBaseInvalidDataException{
		if(getProveedor(proveedor)!=null){
			proveedores.remove(proveedor);
			CprDAO.getInstancia().eliminarProveedor(proveedor);
		}else
			throw new DataBaseInvalidDataException();
	}

	public Proveedor getProveedor(Proveedor prove) throws DataBaseInvalidDataException {
		for(Proveedor p: proveedores)
			if(p.equals(prove))
				return p;
		return CprDAO.getInstancia().getProveedor(prove);
	}

	public float getPorcentajeGanancia() {
		return CprDAO.getInstancia().getPorcentajeGanancia();
	}
	
	public void setPorcentajeGanancia(float porcentaje) {
		CprDAO.getInstancia().setPorcentajeGanancia(porcentaje);
	}

	public void inicializarPorcentajeGanancia() {
		PorcentajeGanancia pg = new PorcentajeGanancia();
		pg.setNombre("Porcentaje de ganancia");
		pg.setPorcentaje((float) 0.15);
		CprDAO.getInstancia().inicializarPorcentajeGanancia(pg);
	}
}
