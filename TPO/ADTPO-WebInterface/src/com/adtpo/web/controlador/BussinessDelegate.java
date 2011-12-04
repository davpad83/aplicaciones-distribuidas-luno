package com.adtpo.web.controlador;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.adtpo.cpr.bean.gui.*;
import com.adtpo.cpr.controlador.Facade;
import com.adtpo.cpr.ro.IServicios;


public class BussinessDelegate {

	private IServicios servicios;
	
	//Enviados al Facade
	
	public ClienteBean getCliente(int idCliente) throws Exception {
		return servicios.getCliente(idCliente);
	}

	public FacturaBean enviarSolicitudVenta(SolicitudVentaBean solicitud) {
		return servicios.enviarSolicitudVenta(solicitud);
	}

	public CotizacionBean enviarSolicitudDeCotizacion(String nombreDeCotizacion) {
		return servicios.enviarSolicitudDeCotizacion(nombreDeCotizacion); 
	}
	
	public ArrayList<CotizacionBean> getCotizacionesCliente(int idCliente){
		//TODO
		return null;
	}

}
