package com.adtpo.ov.clienteRmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.rmi.IServicios;

public class ClienteRmi {
	
	private IServicios servicios;
	
	public ClienteRmi() throws Exception{
		connect();
	}
	
	private void connect() throws Exception{
		servicios = (IServicios) Naming.lookup("//localhost/servicios");
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email) throws Exception{
		ClienteBean cl = new ClienteBean();
		cl.setNombre(nombre);
		cl.setApellido(apellido);
		cl.setTelefono(telefono);
		cl.setEmail(email);
		servicios.agregarCliente(cl);
	}
	
	public void eliminarCliente(Integer idCliente) throws Exception{
		servicios.eliminarCliente(idCliente);
	}

	public void agregarProveedor(String nombre, Float descuento) throws Exception{
		
	}

	public void eliminarProveedor(Integer idProveedor) throws Exception{
		servicios.eliminarProveedor(idProveedor);
	}

	public void eliminarRodamiento(Integer idRodamiento) throws Exception{
		servicios.eliminarRodamiento(idRodamiento);
	}

	public void setPorcentajeDeGanancia(Float porcentaje) throws Exception{
		servicios.setPorcentajeDeGanancia(porcentaje);
	}

	public void agregarRodamiento(Integer codigo, String marca, String origen,
			String caracteristica, String precioUnitario,
			boolean marcaAlternativa) throws Exception{
		// TODO Auto-generated method stub
		
	}

	public void nuevaCondicionVenta(Float interes, String tipo) throws Exception{
		CondicionVentaBean cvb = new CondicionVentaBean();
		cvb.setInteres(interes);
		cvb.setTipo(tipo);
		servicios.nuevaCondicionVenta(cvb);
	}
}
