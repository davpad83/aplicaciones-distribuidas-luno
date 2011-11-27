package com.adtpo.cpr.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;
import com.adtpo.cpr.beans.model.OficinaVentas;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.hql.ConsultasHQL;
import com.adtpo.cpr.ro.IServicios;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	
	private static final long serialVersionUID = -8744487297781366413L;

	public ServiciosImpl() throws RemoteException{
		//empty
	}

	@Override
	public void agregarCliente(ClienteBean cliente) throws RemoteException {
		OficinaVentas.getInstancia().agregarCliente(toCliente(cliente));
	}
	
	@Override
	public void eliminarCliente(Integer idCliente) throws RemoteException {
		Cliente cl = new Cliente();
		cl.setIdCliente(idCliente);
		OficinaVentas.getInstancia().eliminarCliente(cl);
	}

	@Override
	public void agregarProveedor(ProveedorBean pb) throws RemoteException {
		CasaCentral.getInstancia().agregarProveedor(toProveedor(pb));
	}

	@Override
	public void eliminarProveedor(Integer idProveedor) throws RemoteException {
		Proveedor prove = new Proveedor();
		prove.setIdProveedor(idProveedor);
		CasaCentral.getInstancia().eliminarProveedor(prove);
	}

	@Override
	public void eliminarProveedor(String cuit) throws RemoteException {
		Proveedor prove = new Proveedor();
		prove.setCuit(cuit);
		CasaCentral.getInstancia().eliminarProveedor(prove);
	}

	@Override
	public void agregarRodamiento(RodamientoBean rodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRodamiento(Integer idRodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	private Cliente toCliente(ClienteBean cb){
		Cliente cliente = new Cliente();
		cliente.setApellido(cb.getApellido());
		
		if(cb.getCondicion() != null){
			List<CondicionVenta> condicion = new ArrayList<CondicionVenta>();
			for(CondicionVentaBean cvb: cb.getCondicion()){
				condicion.add(toCondicionVenta(cvb));
			}
			cliente.setCondicion(condicion);
		}
		
		cliente.setNombre(cb.getNombre());
		cliente.setTelefono(cb.getTelefono());
		cliente.setEmail(cb.getEmail());
		
		return cliente;
	}

	private Proveedor toProveedor(ProveedorBean pb) {
		Proveedor p = new Proveedor();
		p.setCuit(pb.getCuit());
		p.setNombre(pb.getNombre());
		return p;
	}
	
	private CondicionVenta toCondicionVenta(CondicionVentaBean cvb){
		CondicionVenta condicion = new CondicionVenta();
		condicion.setInteres(cvb.getInteres());
		condicion.setTipo(cvb.getTipo());		
		return condicion;
	}

	@Override
	public void setPorcentajeDeGanancia(Float porcentaje) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevaCondicionVenta(CondicionVentaBean cvb)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, String> getNombresProveedores()
			throws RemoteException {
		return ConsultasHQL.getInstancia().consultarNombresProveedores();
	}


}