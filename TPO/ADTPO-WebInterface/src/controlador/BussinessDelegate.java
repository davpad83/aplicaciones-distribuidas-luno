package controlador;

import com.adtpo.cpr.beans.model.Cliente;
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

	public void enviarSolicitudCotizacion(SolicitudCotizacion solicitud) {
		// TODO Auto-generated method stub
		
	}

	public void enviarSolicitudVenta(SolicitudVenta solicitud) {
		// TODO Auto-generated method stub
		
	}

	
}
