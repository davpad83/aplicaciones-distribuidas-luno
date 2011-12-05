package com.adtpo.web.controlador;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.ro.IServicios;


public class BussinessDelegate {

	private IServicios servicios;
	
	public ClienteBean getCliente(int idCliente) throws Exception {
		return servicios.getCliente(idCliente);
	}

	public FacturaBean enviarSolicitudVenta(File xml) throws RemoteException, Exception {
		return servicios.enviarSolicitudVenta(xml);
	}

	public CotizacionBean enviarSolicitudDeCotizacion(File xml) throws RemoteException, Exception {
		return servicios.enviarSolicitudDeCotizacion(xml); 
	}
	
	public ArrayList<CotizacionBean> getCotizacionesCliente(int idCliente) throws RemoteException, Exception{
		return servicios.getCotizacionesCliente(idCliente);
	}
	
	public ListaComparativaBean getListaComparativa() throws RemoteException{
		return servicios.getListaComparativa();
	}
		
}
