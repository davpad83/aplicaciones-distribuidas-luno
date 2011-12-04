package com.adtpo.cpr.controlador;

import java.util.ArrayList;
import com.adtpo.cpr.beans.model.*;
import com.thoughtworks.xstream.XStream;

public class Facade {

	//LLamado desde el Bussiness Delegate
	
	
	
	public Cliente getCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO Arreglar esto
	
//	public Factura procesarSolicitudVenta (String pathXML) {
//		return OficinaVentas.getInstancia().procesarSolicitudVenta(pathXML);
//	}
//
//	public Cotizacion enviarSolicitudDeCotizacion(String PathXML) {
//		XStream xml = new XStream();
//		SolicitudCotizacion sc = (SolicitudCotizacion) xml.fromXML(PathXML);
//		OficinaVentas.getInstancia().generarCotizacion(sc.getCliente().getIdCliente(), (ArrayList<ItemRodamiento>) (sc.getRodamientos()));
//	}

	public Factura enviarSolicitudVenta(SolicitudVenta solicitud) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
	
