package controlador;

import java.util.ArrayList;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.Cotizacion;
import com.adtpo.cpr.beans.model.Factura;
import com.adtpo.cpr.beans.model.ItemRodamiento;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;
import com.adtpo.cpr.beans.model.SolicitudVenta;
import com.adtpo.cpr.controlador.Facade;
import com.adtpo.cpr.ro.IServicios;


public class BussinessDelegate {

	private IServicios servicios;
	
	//Enviados al Facade
	
	public ClienteBean getCliente(int idCliente) {
		return servicios.getCliente(idCliente);
	}

	public Factura enviarSolicitudVenta(SolicitudVenta solicitud) {
		return servicios.enviarSolicitudVenta(solicitud);
	}

	public Integer obtenerIdCotizacion(ArrayList<ItemRodamiento> rodamientos) {
		return servicios.obtenerIdCotizacion(rodamientos);   
	}

	public Cotizacion enviarSolicitudDeCotizacion(String nombreDeCotizacion) {
		return servicios.enviarSolicitudDeCotizacion(nombreDeCotizacion); 
	}

}
