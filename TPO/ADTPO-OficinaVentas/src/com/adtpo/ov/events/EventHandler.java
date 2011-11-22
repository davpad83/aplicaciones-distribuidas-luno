package com.adtpo.ov.events;

import com.adtpo.ov.clienteRmi.ClienteRmi;

public class EventHandler {
	
	private static ClienteRmi clienteRmi;
	
	public EventHandler(){
		clienteRmi = new ClienteRmi();
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email){
		if((!nombre.isEmpty() && !apellido.isEmpty()) || telefono.length() > 10)
			clienteRmi.agregarCliente(nombre, apellido, telefono, email);
//		else
//			throw new DataEntryException();
	}
	
	public void agregarProveedor(String nombre, Float descuento){
		clienteRmi.agregarProveedor(nombre, descuento);		
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
