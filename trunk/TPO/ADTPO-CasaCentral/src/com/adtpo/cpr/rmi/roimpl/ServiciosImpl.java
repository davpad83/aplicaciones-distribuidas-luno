package com.adtpo.cpr.rmi.roimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.rmi.ro.IServicios;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	
	private static final long serialVersionUID = -8744487297781366413L;

	public ServiciosImpl() throws RemoteException{
		
	}

	@Override
	public void agregarCliente(ClienteBean cliente) throws RemoteException {
		
	}

}
