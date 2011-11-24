package com.adtpo.ov.events;

import javax.swing.JTextField;

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

	public void modificarCliente(){
		
	}
	
	public void eliminarCliente(Integer idCliente){
		if(idCliente > 0)
			clienteRmi.eliminarCliente(idCliente);
	}

	public void agregarProveedor(String nombre, Float descuento){
		if(!nombre.isEmpty() && descuento.isNaN())
			clienteRmi.agregarProveedor(nombre, descuento);		
	}

	public void modificarProveedor(){
		
	}
	
	public void eliminarProveedor(Integer idProveedor){
		if(idProveedor>0){
			clienteRmi.eliminarProveedor(idProveedor);
		}
	}
	
	public void agregarRodamiento(Integer codigo, String marca, String origen, String caracteristica
			, String precioUnitario, boolean marcaAlternativa){
		if(codigo>0 && !marca.isEmpty() && !origen.isEmpty() && !caracteristica.isEmpty() && !precioUnitario.isEmpty())
			clienteRmi.agregarRodamiento(codigo, marca, origen, caracteristica, precioUnitario, marcaAlternativa);
	}
	
	public void eliminarRodamiento(Integer idRodamiento){
		if(idRodamiento>0){
			clienteRmi.eliminarRodamiento(idRodamiento);
		}
	}
	
	public void setPorcentajeDeGanancia(Float porcentaje){
		if(porcentaje >0){
			clienteRmi.setPorcentajeDeGanancia(porcentaje);
		}
	}

	public void nuevaCondicionVenta(Float interes, String tipo) {
		clienteRmi.nuevaCondicionVenta(interes, tipo);
	}
}
