package controlador;

import java.util.ArrayList;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.Cotizacion;
import com.adtpo.cpr.beans.model.Factura;
import com.adtpo.cpr.beans.model.ItemRodamiento;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;
import com.adtpo.cpr.beans.model.SolicitudVenta;


public class BussinessDelegate {

	private Facade facade = new Facade();
	
	//Enviados al Facade
	
	public Cliente getCliente(int idCliente) {
		return facade.getCliente(idCliente);
	}

	public Factura enviarSolicitudVenta(SolicitudVenta solicitud) {
		return facade.enviarSolicitudVenta(solicitud);
	}

	public Integer obtenerIdCotizacion(ArrayList<ItemRodamiento> rodamientos) {
		return facade.obtenerIdCotizacion(rodamientos);   
	}

	public Cotizacion enviarSolicitudDeCotizacion(String nombreDeCotizacion) {
		return facade.enviarSolicitudDeCotizacion(nombreDeCotizacion); 
	}

}
