package com.adtpo.ov.events;

import java.util.HashMap;

import javax.swing.JTextField;

import com.adtpo.ov.clienteRmi.ClienteRmi;
import com.adtpo.ov.excepciones.DataEntryException;

public class EventHandler {
	
	private static ClienteRmi clienteRmi;
	
	public EventHandler() throws Exception{
		clienteRmi = new ClienteRmi();
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email) throws DataEntryException, Exception{
		if((!nombre.isEmpty() && !apellido.isEmpty()) || telefono.length() > 10)
			clienteRmi.agregarCliente(nombre, apellido, telefono, email);
		else
			throw new DataEntryException();
	}

	public void modificarCliente(){
		
	}
	
	public void eliminarCliente(Integer idCliente) throws Exception{
		if(idCliente > 0)
			clienteRmi.eliminarCliente(idCliente);
		else
			throw new DataEntryException();
	}

	public void agregarProveedor(String cuit, String nombre) throws DataEntryException, Exception{
		if(!cuit.isEmpty())
			clienteRmi.agregarProveedor(cuit, nombre);		
		else
			throw new DataEntryException();
	}

	public void modificarProveedor(){
		
	}
	
	public void eliminarProveedor(Integer idProveedor, String cuit) throws DataEntryException, Exception{
		if(idProveedor>0 && !cuit.isEmpty())
			if(idProveedor>0)
				clienteRmi.eliminarProveedor(idProveedor);
			else
				clienteRmi.eliminarProveedor(cuit);
		else
			throw new DataEntryException();
	}
	
	public void agregarRodamiento(Integer codigo, String marca, String origen, String caracteristica
			, String precioUnitario, boolean marcaAlternativa) throws DataEntryException, Exception{
		if(codigo>0 && !marca.isEmpty() && !origen.isEmpty() && !caracteristica.isEmpty() && !precioUnitario.isEmpty())
			clienteRmi.agregarRodamiento(codigo, marca, origen, caracteristica, precioUnitario, marcaAlternativa);
		else
			throw new DataEntryException();
	}
	
	public void eliminarRodamiento(Integer idRodamiento) throws DataEntryException, Exception{
		if(idRodamiento>0)
			clienteRmi.eliminarRodamiento(idRodamiento);
		else
			throw new DataEntryException();
	}
	
	public void setPorcentajeDeGanancia(Float porcentaje) throws DataEntryException, Exception{
		if(porcentaje >0)
			clienteRmi.setPorcentajeDeGanancia(porcentaje);
		else
			throw new DataEntryException();
	}

	public void nuevaCondicionVenta(Float interes, String tipo) throws DataEntryException, Exception{
		clienteRmi.nuevaCondicionVenta(interes, tipo);
	}
	
	public HashMap<String, String> getNombresProveedores() throws Exception{
		return clienteRmi.getNombresProveedores();
	}
}
