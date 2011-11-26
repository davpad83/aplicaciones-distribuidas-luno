package com.adtpo.cpr.beans.model;

public class CasaCentral {
	
	private static CasaCentral instancia;
	
	public CasaCentral(){
	}
	
	public static CasaCentral getInstancia() {
		if (instancia == null) {
			instancia = new CasaCentral();
		}
		return instancia;
	}
	
	

}
