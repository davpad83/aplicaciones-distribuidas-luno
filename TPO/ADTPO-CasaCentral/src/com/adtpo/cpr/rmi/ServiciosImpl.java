package com.adtpo.cpr.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.adtpo.cpr.bean.dao.ClienteDAO;
import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	
	private static final long serialVersionUID = -8744487297781366413L;

	public ServiciosImpl() throws RemoteException{
		
	}

	@Override
	public void agregarCliente(ClienteBean cliente) throws RemoteException {
		ClienteDAO.getInstancia().grabarCliente(toCliente(cliente));
	}
	
	private Cliente toCliente(ClienteBean cb){
		Cliente cliente = new Cliente();
		cliente.setApellido(cb.getApellido());
		
//		ArrayList<CondicionVenta> condicion = new ArrayList<CondicionVenta>();
//		for(CondicionVentaBean cvb: cb.getCondicion()){
//			condicion.add(toCondicionVenta(cvb));
//		}
//		cliente.setCondicion(condicion);
		
		cliente.setNombre(cb.getNombre());
		cliente.setTelefono(cb.getTelefono());
		
		
		return cliente;
	}
	
	private CondicionVenta toCondicionVenta(CondicionVentaBean cvb){
		CondicionVenta condicion = new CondicionVenta();
		condicion.setDescuento(cvb.getDescuento());
		condicion.setInteres(cvb.getInteres());
		condicion.setTipo(cvb.getTipo());		
		return condicion;
	}

}