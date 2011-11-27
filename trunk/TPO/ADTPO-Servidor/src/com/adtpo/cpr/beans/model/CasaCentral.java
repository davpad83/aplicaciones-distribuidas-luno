package com.adtpo.cpr.beans.model;

import java.util.ArrayList;

import com.adtpo.cpr.bean.dao.CprDAO;

public class CasaCentral {
	
	private static CasaCentral instancia;
	
	private ArrayList<Proveedor> proveedores;
	
	public CasaCentral(){
		proveedores = new ArrayList<Proveedor>();
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
