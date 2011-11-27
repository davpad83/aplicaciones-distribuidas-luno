package com.adtpo.cpr.ro;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.CondicionVentaBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.cpr.bean.gui.RodamientoBean;


public interface IServicios extends Remote{
	
	public void agregarCliente(ClienteBean cliente) throws RemoteException;

	public void eliminarCliente(Integer idCliente) throws RemoteException;
	
	public void agregarProveedor(ProveedorBean pv) throws RemoteException;

	public void agregarRodamiento(RodamientoBean rodamiento) throws RemoteException;
	
	public void eliminarRodamiento(Integer idRodamiento) throws RemoteException;

	public void eliminarProveedor(Integer idProveedor) throws RemoteException;
	
	public void eliminarProveedor(String cuit) throws RemoteException;

	public void setPorcentajeDeGanancia(Float porcentaje) throws RemoteException;

	public void nuevaCondicionVenta(CondicionVentaBean cvb) throws RemoteException;
	
	public HashMap<String, String> getNombresProveedores() throws RemoteException;


	
}
