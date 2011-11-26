package com.adtpo.cpr.hql;

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
	
	public String[][] consultarNombresProveedores(){
		String[][] proveedores = null;
		
		
		
		return proveedores;
	}

}
