package com.adtpo.cpr.rmi;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

import com.adtpo.cpr.bean.dao.OficinaVentaDAO;
import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.ListasProveedor;
import com.adtpo.cpr.beans.model.OficinaVentas;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.ro.IServicios;
import com.thoughtworks.xstream.XStream;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	
	private static final long serialVersionUID = -8744487297781366413L;

	public ServiciosImpl() throws RemoteException{
		//empty
	}

	@Override
	public void agregarCliente(ClienteBean cliente) throws RemoteException {
		OficinaVentas.getInstancia().agregarCliente(BeanTransformer.toCliente(cliente));
	}
	
	@Override
	public void modificarCliente(ClienteBean cl) throws RemoteException, DataBaseInvalidDataException {
		OficinaVentas.getInstancia().modificarCliente(BeanTransformer.toCliente(cl));
	}

	@Override
	public void eliminarCliente(int idCliente) throws RemoteException {
		Cliente cl = new Cliente();
		cl.setIdCliente(idCliente);
		try {
			OficinaVentas.getInstancia().eliminarCliente(cl);
		} catch (DataBaseInvalidDataException e) {
			System.err.print(e.mensaje);
		}
	}
	
	@Override
	public ClienteBean getCliente(int idCliente) throws RemoteException, Exception{
		Cliente cl = new Cliente();
		cl.setIdCliente(idCliente);
		return BeanTransformer.toClienteBean(OficinaVentas.getInstancia().getCliente(cl));
	}

	@Override
	public void agregarProveedor(ProveedorBean pb) throws RemoteException {
		CasaCentral.getInstancia().agregarProveedor(BeanTransformer.toProveedor(pb));
	}

	@Override
	public void eliminarProveedor(int idProveedor) throws RemoteException{
		Proveedor prove = new Proveedor();
		prove.setIdProveedor(idProveedor);
		try {
			CasaCentral.getInstancia().eliminarProveedor(prove);
		} catch (DataBaseInvalidDataException e) {
			System.err.print(e.mensaje);
		}
	}

	@Override
	public void eliminarProveedor(String cuit) throws RemoteException {
		Proveedor prove = new Proveedor();
		prove.setCuit(cuit);
		try {
			CasaCentral.getInstancia().eliminarProveedor(prove);
		} catch (DataBaseInvalidDataException e) {
			System.err.print(e.mensaje);
		}
	}

	@Override
	public void agregarStockRodamiento(RodamientoBean rod, int cantidad) throws RemoteException{
		CasaCentral.getInstancia().agregarStockRodamiento(BeanTransformer.toRodamiento(rod)
				, cantidad);
	}

	@Override
	public void eliminarStockRodamiento(RodamientoBean rod, int cantidad) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setPorcentajeDeGanancia(float porcentaje) throws RemoteException {
		CasaCentral.getInstancia().setPorcentajeGanancia(porcentaje);
	}

	@Override
	public void nuevaCondicionVenta(CondicionVentaBean cvb)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void cargarListaProveedor(String nombre, File listaXML) throws RemoteException{
		try{
			XStream stream = new XStream();
			ListasProveedorBean lpb = (ListasProveedorBean) stream.fromXML(listaXML);
			CasaCentral.getInstancia().agregarListaProveedor(BeanTransformer.toListaProveedor(lpb));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ListaComparativaBean getListaComparativa() throws RemoteException {
		return BeanTransformer.toListaComparativaBean(CasaCentral.getInstancia().getListaComparativa());
	}

	@Override
	public CotizacionBean enviarSolicitudDeCotizacion(String nombreDeCotizacion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaBean enviarSolicitudVenta(SolicitudVentaBean solicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarProveedor(ProveedorBean pb) throws RemoteException, Exception {
		CasaCentral.getInstancia().modificarProveedor(BeanTransformer.toProveedor(pb));
	}
	
	public ProveedorBean getProveedor(int idProveedor) throws RemoteException, Exception{
		Proveedor prove = new Proveedor();
		prove.setIdProveedor(idProveedor);
		return BeanTransformer.toProveedorBean(CasaCentral.getInstancia().getProveedor(prove));
	}

	@Override
	public CotizacionBean enviarSolicitudDeCotizacion(File xml)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaBean enviarSolicitudVenta(File xml) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
