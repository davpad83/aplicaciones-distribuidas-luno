package com.adtpo.cpr.rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.ListasProveedor;
import com.adtpo.cpr.beans.model.OficinaVentas;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.ro.IServicios;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ServiciosImpl extends UnicastRemoteObject implements IServicios{
	private XStream stream = new XStream(new DomDriver());
	
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
		CasaCentral.getInstancia().agregarStockRodamiento(BeanTransformer.toRodamiento(rod), cantidad);
	}

	@Override
	public void eliminarStockRodamiento(RodamientoBean rod, int cantidad) throws RemoteException {
		CasaCentral.getInstancia().eliminarStockRodamiento(BeanTransformer.toRodamiento(rod), cantidad);
		
	}
	
	@Override
	public void setPorcentajeDeGanancia(float porcentaje) throws RemoteException {
		CasaCentral.getInstancia().setPorcentajeGanancia(porcentaje);
	}

	public void cargarListaProveedor(File listaXML){
		try{
		ListasProveedorBean lp = (ListasProveedorBean) stream.fromXML(new FileInputStream(listaXML));;
		CasaCentral.getInstancia().agregarListaProveedor(BeanTransformer.toListaProveedor(lp));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ListaComparativaBean getListaComparativa() throws RemoteException {
		return BeanTransformer.toListaComparativaBean(CasaCentral.getInstancia().getListaComparativa());
	}


	@Override
	public void modificarProveedor(ProveedorBean pb) throws RemoteException,Exception {
		Proveedor p = BeanTransformer.toProveedor(pb);
		CasaCentral.getInstancia().modificarProveedor(p);
		
	}

	@Override
	public ProveedorBean getProveedor(int idProveedor) throws RemoteException,Exception {
		Proveedor prove = new Proveedor();
		prove.setIdProveedor(idProveedor);
		return BeanTransformer.toProveedorBean(CasaCentral.getInstancia().getProveedor(prove));
	}

	@Override
	public FacturaBean enviarSolicitudVenta(File xml) throws RemoteException, Exception {
		SolicitudVentaBean solicitud = (SolicitudVentaBean) stream.fromXML(new FileInputStream(xml));
		return BeanTransformer.toFacturaBean(OficinaVentas.getInstancia().generarVenta(solicitud.getCliente().getId(),BeanTransformer.toItemRodamientoList(solicitud.getRodamientos())));

	}

	@Override
	public CotizacionBean enviarSolicitudDeCotizacion()	throws RemoteException, Exception {
		SolicitudCotizacionBean solicitud = (SolicitudCotizacionBean) stream.fromXML(new FileInputStream("C://xml//listaPrecios.xml"));
		//TODO
		System.out.println(solicitud.getRodamientos().get(0).getRodamiento().getCodigo());
		return BeanTransformer.toCotizacionBean(OficinaVentas.getInstancia().generarCotizacion(solicitud.getCliente().getId(),BeanTransformer.toItemRodamientoList(solicitud.getRodamientos())));
	}

	@Override
	public void cargarListaProveedor(String nombre, File archivoXML) throws RemoteException {
		ListasProveedorBean lpb = null;
		try{
			lpb = (ListasProveedorBean) stream.fromXML(new FileInputStream(archivoXML));
			lpb.setNombre(nombre);
		}catch (Exception e){
			e.printStackTrace();
		}
		CasaCentral.getInstancia().agregarListaProveedor(BeanTransformer.toListaProveedor(lpb));
	}

	@Override
	public void nuevaCondicionVenta(CondicionVentaBean cvb)
			throws RemoteException, Exception {
		//TODO
	}
	
	public ArrayList<CotizacionBean> getCotizacionesCliente(int idCliente) throws RemoteException, Exception{
		Cliente cli = BeanTransformer.toCliente(getCliente(idCliente));
		return BeanTransformer.toCotizacionBeanList(CasaCentral.getInstancia().getCotizacionesCliente(cli));
	}
}
