package com.adtpo.cpr.ro;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.adtpo.cpr.bean.gui.*;


public interface IServicios extends Remote{
	
	public void agregarCliente(ClienteBean cliente) throws RemoteException, Exception;

	public void eliminarCliente(int idCliente) throws RemoteException, Exception;
	
	public void agregarProveedor(ProveedorBean pv) throws RemoteException, Exception;

	public void agregarStockRodamiento(RodamientoBean rod, int cantidad) throws RemoteException;
	
	public void eliminarStockRodamiento(RodamientoBean rod, int cantidad) throws RemoteException, Exception;

	public void eliminarProveedor(int idProveedor) throws RemoteException, Exception;
	
	public void eliminarProveedor(String cuit) throws RemoteException, Exception;

	public void setPorcentajeDeGanancia(float porcentaje) throws RemoteException, Exception;

	public void nuevaCondicionVenta(CondicionVentaBean cvb) throws RemoteException, Exception;

	public void modificarCliente(ClienteBean cl) throws RemoteException, Exception;

	public ClienteBean getCliente(int idCliente) throws RemoteException, Exception;

	public FacturaBean enviarSolicitudVenta(SolicitudVentaBean solicitud);

	public CotizacionBean enviarSolicitudDeCotizacion(String nombreDeCotizacion);

	public ListaComparativaBean getListaComparativa() throws RemoteException;

	public void cargarListaProveedor(File archivoXML) throws RemoteException;

	
}
