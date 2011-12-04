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
	public void agregarRodamiento(RodamientoBean rodamiento) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRodamiento(int idRodamiento) throws RemoteException {
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

	
	public void cargarListaProveedor(File listaXML){
		try{
			XStream stream = new XStream();
			ListasProveedor lp = (ListasProveedor) stream.fromXML(listaXML);
			System.out.print("Datos lista: "+lp.getIdLista()+lp.getNombre());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ListasProveedorBean getListaComparativa() throws RemoteException {
		return BeanTransformer.toListaProveedorBean(CasaCentral.getInstancia().getListaComparativa());
	}

}
