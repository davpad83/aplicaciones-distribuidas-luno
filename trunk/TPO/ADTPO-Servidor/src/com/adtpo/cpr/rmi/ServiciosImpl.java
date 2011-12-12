package com.adtpo.cpr.rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.CondicionVenta;
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
	public void agregarCliente(ClienteBean cliente) throws RemoteException, DataBaseInvalidDataException {
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
	public void agregarProveedor(ProveedorBean pb) throws RemoteException, Exception {
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

	@Override
	public ListaComparativaBean getListaComparativa() throws RemoteException {
		return BeanTransformer.toListaComparativaBean(CasaCentral.getInstancia().getListaComparativa());
		//getLista();
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
	public void cargarListaProveedor(File archivoXML) throws Exception {
		ListasProveedorBean lpb = null;
		try{
			stream.alias("CondicionVentaBean", CondicionVentaBean.class);
			stream.alias("MapaRodamientoPrecioBean", MapaRodamientoPrecioBean.class);
			stream.alias("RodamientoBean", RodamientoBean.class);
			stream.alias("ProveedorBean", ProveedorBean.class);
			lpb = (ListasProveedorBean) stream.fromXML(new FileInputStream(archivoXML));
		}catch (Exception e){
			e.printStackTrace();
		}
		ListasProveedor lp = BeanTransformer.toListaProveedor(lpb);
		CasaCentral.getInstancia().agregarProveedor(lp.getProveedor());
		CasaCentral.getInstancia().agregarMapaRodamientoPrecioList(
				lp.getMapaRodamientoPrecio());

		lp.setMapaRodamientoPrecio(CasaCentral.getInstancia()
				.getMapaRodamientoPrecioList(lp.getMapaRodamientoPrecio()));
		CasaCentral.getInstancia().agregarListaProveedor(lp);
	}
	
	@Override
	public void cargarListaProveedor(String archivoXML)
			throws RemoteException, Exception {
		ListasProveedorBean lpb = null;
		try{
			stream.alias("CondicionVentaBean", CondicionVentaBean.class);
			stream.alias("MapaRodamientoPrecioBean", MapaRodamientoPrecioBean.class);
			stream.alias("RodamientoBean", RodamientoBean.class);
			stream.alias("ProveedorBean", ProveedorBean.class);
			lpb = (ListasProveedorBean) stream.fromXML(new FileInputStream(archivoXML));
		}catch (Exception e){
			e.printStackTrace();
		}	

		ListasProveedor lp = BeanTransformer.toListaProveedor(lpb);
//		CasaCentral.getInstancia().agregarProveedor(lp.getProveedor());
//		CasaCentral.getInstancia().agregarMapaRodamientoPrecioList(
//				lp.getMapaRodamientoPrecio());
		lp.setMapaRodamientoPrecio(CasaCentral.getInstancia()
				.getMapaRodamientoPrecioList(lp.getMapaRodamientoPrecio()));
		CasaCentral.getInstancia().agregarListaProveedor(lp);
	}

	@Override
	public void nuevaCondicionVenta(CondicionVentaBean cvb)
			throws RemoteException, Exception {
		CasaCentral.getInstancia().nuevaCondicionVenta(BeanTransformer.toCondicionVenta(cvb));
	}
	
	public ArrayList<CotizacionBean> getCotizacionesCliente(int idCliente) throws RemoteException, Exception{
		Cliente cli = BeanTransformer.toCliente(getCliente(idCliente));
		return BeanTransformer.toCotizacionBeanList(CasaCentral.getInstancia().getCotizacionesCliente(cli));
	}
	
	private ListaComparativaBean getLista() {

		ProveedorBean pr2 = new ProveedorBean();
		pr2.setCuit("34536542");
//		pr2.setDescuento(1.5f);
		pr2.setNombre("Rodriguez s.a.");
		pr2.setId(2);
		ProveedorBean pr1 = new ProveedorBean();
		pr1.setCuit("34538792");
//		pr1.setDescuento(7.2f);
		pr1.setNombre("sanchez s.a.");
		pr1.setId(1);

		RodamientoBean r1 = new RodamientoBean();
		r1.setCaracteristica("Permeable");
		r1.setCodigo("AAA001");
		r1.setMarca("Yamaha");
		r1.setPais("Japon");

		RodamientoBean r2 = new RodamientoBean();
		r2.setCaracteristica("Flexible");
		r2.setCodigo("XYZ127");
		r2.setMarca("Yamaha");
		r2.setPais("Argentina");

		RodamientoBean r3 = new RodamientoBean();
		r3.setCaracteristica("Acero Inoxidable");
		r3.setCodigo("AZZ012");
		r3.setMarca("Taranto");
		r3.setPais("Japon");

		MapaRodamientoPrecioBean mrp1 = new MapaRodamientoPrecioBean(r1, 15f);
		MapaRodamientoPrecioBean mrp2 = new MapaRodamientoPrecioBean(r2, 85f);
		MapaRodamientoPrecioBean mrp3 = new MapaRodamientoPrecioBean(r3, 11f);

		ArrayList<MapaRodamientoPrecioBean> Rodamientos1 = new ArrayList<MapaRodamientoPrecioBean>();
		Rodamientos1.add(mrp1);
		Rodamientos1.add(mrp2);
		Rodamientos1.add(mrp3);

		ArrayList<CondicionVentaBean> cvs = new ArrayList<CondicionVentaBean>();

		ListasProveedorBean lpb = new ListasProveedorBean();
		lpb.setNombre("lista a");
		lpb.setProveedor(pr2);
		lpb.setDescuento(0.21f);
		lpb.setIdLista(1);
		lpb.setMapaRodamientoPrecio(Rodamientos1);
//		lpb.setCondVenta(cvs);

		ListasProveedorBean lpb2 = new ListasProveedorBean();
		lpb2.setNombre("lista b");
		lpb2.setProveedor(pr1);
		lpb2.setDescuento(0.17f);
		lpb2.setIdLista(2);
		lpb2.setMapaRodamientoPrecio(Rodamientos1);
//		lpb2.setCondVenta(cvs);

		ItemListaComparativaBean ilc1 = new ItemListaComparativaBean();
		ilc1.setPrecio(3.6f);
		ilc1.setListaProveedor(lpb);
		ilc1.setRodamiento(r1);

		ItemListaComparativaBean ilc2 = new ItemListaComparativaBean();
		ilc2.setPrecio(7.2f);
		ilc2.setListaProveedor(lpb2);
		ilc2.setRodamiento(r2);

		ItemListaComparativaBean ilc3 = new ItemListaComparativaBean();
		ilc3.setPrecio(2.12f);
		ilc3.setListaProveedor(lpb2);
		ilc3.setRodamiento(r3);

		ArrayList<ItemListaComparativaBean> lilc = new ArrayList<ItemListaComparativaBean>();
		lilc.add(ilc1);
		lilc.add(ilc2);
		lilc.add(ilc3);

		ListaComparativaBean lc = new ListaComparativaBean();
		lc.setFechaLista(new Date());
		lc.setItems(lilc);

		return lc;
	}



}
