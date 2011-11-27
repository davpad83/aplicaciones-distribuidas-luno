package com.adtpo.ov.excepciones;

public class DataEntryException extends Exception {

	private static final long serialVersionUID = 7911660415979096971L;

	public final String mensaje = "Los datos ingresados no son correctos";
	
	public DataEntryException(){
		
	}
}
