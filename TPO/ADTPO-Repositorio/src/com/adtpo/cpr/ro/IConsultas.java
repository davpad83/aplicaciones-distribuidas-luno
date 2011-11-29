package com.adtpo.cpr.ro;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import com.adtpo.cpr.bean.gui.*;


public interface IConsultas extends Remote{
	
	public ClienteBean getCliente(int idCliente) throws RemoteException;
	
	public ProveedorBean getProveedor(int idProveedor) throws RemoteException;

	public HashMap<String, String> getNombresProveedores() throws RemoteException;

	public float getPorcentajeGanancia() throws RemoteException;
}
