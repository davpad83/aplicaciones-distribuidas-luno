package com.adtpo.cpr.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.adtpo.cpr.bean.gui.ClienteBean;

public interface IServicios extends Remote{
	
	public void agregarCliente(ClienteBean cliente) throws RemoteException;

	public void eliminarCliente(Integer idCliente) throws RemoteException;
	
	public void agregarRodamiento(RodamientoBean rodamiento) throws RemoteException;
	
	public void eliminarRodamiento(Integer idRodamiento) throws RemoteException;
	
	
}
