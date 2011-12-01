package controlador;

import java.util.ArrayList;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.Cotizacion;
import com.adtpo.cpr.beans.model.ItemRodamiento;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;
import com.adtpo.cpr.beans.model.SolicitudVenta;


public class BussinessDelegate {

	//TODO provisorio, llama al Facade
	public Cliente getCliente(int idCliente) {
		
		Cliente c = new Cliente();
		c.setIdCliente(idCliente);
		c.setNombre("joaquin");
		c.setApellido("Attanasio");
		
		return c;
	}

	//aca se envia una solicitud de cotizacion y se recibe una cotizacion hecha
	// ni idea como es esta funcion todavia jaj
	public Cotizacion RecibirCotizacion() {
		return null;
		// TODO A
		
	}

	public void enviarSolicitudVenta(SolicitudVenta solicitud) {
		// TODO Auto-generated method stub
		
	}

	public Integer obtenerIdCotizacion(ArrayList<ItemRodamiento> rodamientos) {
		// TODO   //busco el ID de la cotizacion para los rodamientos solicitados en una venta
		return null;
	}

	
}
