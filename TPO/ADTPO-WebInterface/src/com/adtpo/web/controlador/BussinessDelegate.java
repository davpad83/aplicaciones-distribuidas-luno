package com.adtpo.web.controlador;

import java.io.File;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.ro.IServicios;

public class BussinessDelegate {

	private IServicios servicios;

	public BussinessDelegate() {
	}

	private boolean connect() throws Exception {
		servicios = (IServicios) Naming.lookup("//localhost/servicios");
		if (servicios == null)
			return false;
		return true;
	}

	public ClienteBean getCliente(int idCliente) throws Exception {
		ClienteBean cb = null;
		if (connect())
			cb = servicios.getCliente(idCliente);
		return cb;
	}

	public FacturaBean enviarSolicitudVenta(File xml) throws RemoteException,
			Exception {
		FacturaBean fb = null;
		if (connect())
			fb= servicios.enviarSolicitudVenta(xml);
		return fb;
	}

	public CotizacionBean enviarSolicitudDeCotizacion() throws RemoteException,
			Exception {
		CotizacionBean cb = null;
		if (connect())
			cb = servicios.enviarSolicitudDeCotizacion();
		return cb;
	}

	public ArrayList<CotizacionBean> getCotizacionesCliente(int idCliente)
			throws RemoteException, Exception {
		ArrayList<CotizacionBean> cblist =null;
		if (connect())
			cblist = servicios.getCotizacionesCliente(idCliente);
		return cblist;
	}

	public ListaComparativaBean getListaComparativa() throws Exception {
		ListaComparativaBean lcb = null;
		if (connect())
			lcb=  servicios.getListaComparativa();
		return lcb;
	}
}
