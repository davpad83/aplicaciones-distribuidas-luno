package com.adtpo.cpr.excepciones;

public class DataBaseInvalidDataException extends Exception {

	private static final long serialVersionUID = 2334344640658150265L;
	
	public final String mensaje = "El objeto no existe o fue modificado.";

	public DataBaseInvalidDataException() {

	}
}
