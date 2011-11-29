package com.adtpo.ov.events;

import java.util.HashMap;

import com.adtpo.cpr.bean.gui.ClienteBean;
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

	public void modificarCliente(int id, String nombre, String apellido, String telefono, 
			String email) throws DataEntryException, Exception{
		if(id>0 && telefono.length() > 10)
			clienteRmi.modificarCliente(nombre, apellido, telefono, email);
		else
			throw new DataEntryException();
	}
	
	public void eliminarCliente(int idCliente) throws Exception{
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
			throw new DataEntryException();
		else{
			if(idProveedor>0)
				clienteRmi.eliminarProveedor(idProveedor);
			else
				clienteRmi.eliminarProveedor(cuit);
		}
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
	
	public void setPorcentajeDeGanancia(float porcentaje) throws DataEntryException, Exception{
		if(porcentaje >0 && porcentaje <1)
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

	public ClienteBean getCliente(int idCliente) throws DataEntryException, Exception {
		if(idCliente>0)
			return clienteRmi.getCliente(idCliente);
		else
			throw new DataEntryException();
	}

	public float getPorcentajeGanancia() throws Exception {
		return clienteRmi.getPorcentajeGanancia();
	}
}
