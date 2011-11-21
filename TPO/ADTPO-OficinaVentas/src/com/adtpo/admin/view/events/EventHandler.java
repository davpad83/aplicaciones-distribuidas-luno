package com.adtpo.admin.view.events;

import com.adtpo.ov.clienteRmi.ClienteRmi;

public class EventHandler {
	
	ClienteRmi rmi = null;
	
	public EventHandler(){
		rmi = new ClienteRmi();
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email){
		if((!nombre.isEmpty() && !apellido.isEmpty()) || telefono.length() > 10)
			rmi.agregarCliente(nombre, apellido, telefono, email);	
//		else
//			throw new DataEntryException();
	}
	
	public void agregarProveedor(){
		
	}
	
	public void agregarRodamiento(){
		
	}
	
	public void eliminarCliente(){
		
	}
	
	public void eliminarProveedor(){
		
	}
	
	public void eliminarRodamient(){
		
	}
	
	public void modificarCliente(){
		
	}
	
	public void modificarProveedor(){
		
	}
	
	public void setPorcentajeDeGanancia(){
		
	}
	
}
