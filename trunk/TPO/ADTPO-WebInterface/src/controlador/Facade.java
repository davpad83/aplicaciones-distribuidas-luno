package controlador;

import java.util.ArrayList;
import com.adtpo.cpr.beans.model.*;

public class Facade {

	private BussinessDelegate bDelegate= new BussinessDelegate();
	
	//LLamado desde el Bussiness Delegate
	public Cliente getCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer obtenerIdCotizacion(ArrayList<ItemRodamiento> rodamientos) {
		// TODO //busco el ID de la cotizacion para los rodamientos solicitados en una venta
		return null;
	}

	public Cotizacion enviarSolicitudDeCotizacion(String nombreDeCotizacion) {
		return null;// TODO Auto-generated method stub
	}

	public Factura enviarSolicitudVenta(SolicitudVenta solicitud) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
	
