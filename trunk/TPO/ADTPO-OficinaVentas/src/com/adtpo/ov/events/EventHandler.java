package com.adtpo.ov.events;

import com.adtpo.ov.clienteRmi.ClienteRmi;

public class EventHandler {
	
	private static ClienteRmi clienteRmi;
	
	public EventHandler(){
		clienteRmi = new ClienteRmi();
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email, 
			String calle, int numero , int piso, String depto, String localidad){
		clienteRmi.agregarCliente(nombre, apellido, telefono, email, calle, numero, piso, depto, localidad);
	}
	
	public void agregarProveedor(){
		
	}
	
	public void agregarRodamiento(){
		
	}
	
	public void eliminarCliente(){
		
	}
	
	public void eliminarProveedor(){
		
	}
	
	public void eliminarRodamiento(){
		
	}
	
	public void modificarCliente(){
		
	}
	
	public void modificarProveedor(){
		
	}
	
	public void setPorcentajeDeGanancia(){
		
	}
}
