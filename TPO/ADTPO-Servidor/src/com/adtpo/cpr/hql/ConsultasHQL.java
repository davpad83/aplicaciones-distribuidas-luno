package com.adtpo.cpr.hql;

import java.util.HashMap;
import java.util.List;

import com.adtpo.cpr.bean.dao.CprDAO;

public class ConsultasHQL {
	
	private static ConsultasHQL instancia;
	
	public ConsultasHQL(){
		
	}
	
	public static ConsultasHQL getInstancia() {
		if (instancia == null) {
			instancia = new ConsultasHQL();
		}
		return instancia;
	}
	
	public HashMap<String, String> consultarNombresProveedores(){
		List<Object[]> nombres = CprDAO.getInstancia().getNombresProveedores();
		HashMap<String, String> mapaNombres = new HashMap<String, String>();
		
		for(Object[] obj: nombres){
			mapaNombres.put((String)obj[0], (String)obj[1]);
		}	
		return mapaNombres;
	}

}
