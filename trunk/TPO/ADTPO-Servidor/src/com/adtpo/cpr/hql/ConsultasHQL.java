package com.adtpo.cpr.hql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.adtpo.cpr.bean.dao.CprDAO;
import com.adtpo.cpr.beans.model.Proveedor;

public class ConsultasHQL {
	
	private static ConsultasHQL instancia;
	
	public ConsultasHQL(){
		//Empty
	}
	
	public static ConsultasHQL getInstancia() {
		if (instancia == null) {
			instancia = new ConsultasHQL();
		}
		return instancia;
	}
	
	public ArrayList<Proveedor> getProveedores(){
		return (ArrayList<Proveedor>) CprDAO.getInstancia().getProveedores();
	}

}
