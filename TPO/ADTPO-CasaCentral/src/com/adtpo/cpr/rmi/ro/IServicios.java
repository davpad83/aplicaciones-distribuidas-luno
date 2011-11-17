package com.adtpo.cpr.rmi.ro;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.adtpo.cpr.bean.gui.ClienteBean;

public interface IServicios extends Remote{
	
	public void agregarCliente(ClienteBean cliente) throws RemoteException;

}
