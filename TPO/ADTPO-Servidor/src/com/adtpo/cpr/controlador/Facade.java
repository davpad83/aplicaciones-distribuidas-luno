package com.adtpo.cpr.controlador;

import java.util.ArrayList;
import com.adtpo.cpr.beans.model.*;

public class Facade {

	//LLamado desde el Bussiness Delegate
	
	
	
	public Cliente getCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public Factura procesarSolicitudVenta ("path XML") {
		return OficinaVentas.getInstancia().procesarSolicitudVenta("path XML");
	}

	public Cotizacion enviarSolicitudDeCotizacion(String PathXML) {
		return null;// TODO Auto-generated method stub
	}

	public Factura enviarSolicitudVenta(SolicitudVenta solicitud) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
	
