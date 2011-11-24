package com.adtpo.cpr.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.adtpo.cpr.bean.dao.OficinaVentaDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.bean.gui.RodamientoBean;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	
	private static final long serialVersionUID = -8744487297781366413L;

	public ServiciosImpl() throws RemoteException{
		
	}

	@Override
	public void agregarCliente(ClienteBean cliente) throws RemoteException {
		OficinaVentaDAO.getInstancia().grabarCliente(toCliente(cliente));
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
	

	@Override
	public void eliminarCliente(Integer idCliente) throws RemoteException {
		Cliente cl = new Cliente();
		cl.setIdCliente(idCliente);
		OficinaVentaDAO.getInstancia().eliminarCliente(cl);
	}

	@Override
	public void eliminarProveedor(Integer idProveedor) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarRodamiento(RodamientoBean rodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRodamiento(Integer idRodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
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

}
