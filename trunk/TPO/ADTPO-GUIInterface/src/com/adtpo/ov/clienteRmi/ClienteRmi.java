package com.adtpo.ov.clienteRmi;

import java.io.File;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.cpr.bean.gui.RodamientoBean;
import com.adtpo.cpr.ro.IConsultas;
import com.adtpo.cpr.ro.IServicios;

public class ClienteRmi {
	
	private IServicios servicios;
	private IConsultas consultas;
	
	public ClienteRmi() throws Exception{
		connect();
	}
	
	private void connect() throws Exception{
		servicios = (IServicios) Naming.lookup("//localhost/servicios");
		consultas = (IConsultas) Naming.lookup("//localhost/consultas");
	}
	
	public void agregarCliente(String nombre, String apellido, String telefono, String email) throws Exception{
		ClienteBean cl = new ClienteBean();
		cl.setNombre(nombre);
		cl.setApellido(apellido);
		cl.setTelefono(telefono);
		cl.setEmail(email);
		servicios.agregarCliente(cl);
	}

	public void modificarCliente(String nombre, String apellido,
			String telefono, String email) throws Exception {
		ClienteBean cl = new ClienteBean();
		cl.setNombre(nombre);
		cl.setApellido(apellido);
		cl.setTelefono(telefono);
		cl.setEmail(email);
		servicios.modificarCliente(cl);	
	}
	
	public void eliminarCliente(int idCliente) throws Exception{
		servicios.eliminarCliente(idCliente);
	}

	public void agregarProveedor(String cuit, String nombre) throws Exception{
		ProveedorBean pv = new ProveedorBean();
		pv.setCuit(cuit);
		pv.setNombre(nombre);
		servicios.agregarProveedor(pv);
	}

	public ProveedorBean getProveedor(int id) throws Exception {
		return servicios.getProveedor(id);
	}
	
	public void eliminarProveedor(int idProveedor) throws Exception{
		servicios.eliminarProveedor(idProveedor);
	}

	public void eliminarProveedor(String cuit) throws Exception {
		servicios.eliminarProveedor(cuit);
	}

	public void eliminarStockRodamiento(String codigo, String marca, String origen,
			String caracteristica, int cantidad) throws Exception{
		RodamientoBean rod = new RodamientoBean();
		rod.setCodigo(codigo);
		rod.setMarca(marca);
		rod.setCaracteristica(caracteristica);
		rod.setPais(origen);
		servicios.eliminarStockRodamiento(rod, cantidad);
	}

	public void setPorcentajeDeGanancia(Float porcentaje) throws Exception{
		servicios.setPorcentajeDeGanancia(porcentaje);
	}

	public void agregarRodamiento(String codigo, String marca, String origen,
			String caracteristica, int cantidad) throws Exception{
		RodamientoBean rod = new RodamientoBean();
		rod.setCodigo(codigo);
		rod.setMarca(marca);
		rod.setCaracteristica(caracteristica);
		rod.setPais(origen);
		servicios.agregarStockRodamiento(rod, cantidad);
	}

	public void nuevaCondicionVenta(Float interes, String tipo) throws Exception{
		CondicionVentaBean cvb = new CondicionVentaBean();
		cvb.setInteres(interes);
		cvb.setTipo(tipo);
		servicios.nuevaCondicionVenta(cvb);
	}

	public ArrayList<ProveedorBean> getProveedores() throws Exception {
		return consultas.getProveedores();
	}

	public ClienteBean getCliente(int idCliente) throws Exception{
		return consultas.getCliente(idCliente);
	}

	public float getPorcentajeGanancia() throws Exception {
		return consultas.getPorcentajeGanancia();
	}

	public ArrayList<ListasProveedorBean> getListasProveedor(int idProveedor) throws Exception {
		return consultas.getListasProveedor(idProveedor);
	}

	public void agregarListaProveedor(File archivoXML) throws Exception {
		servicios.cargarListaProveedor(archivoXML);
	}

	public void modificarProveedor(int id, String nombre) throws Exception {
		ProveedorBean pb = new ProveedorBean();
		pb.setId(id);
		pb.setNombre(nombre);
		servicios.modificarProveedor(pb);
	}

}