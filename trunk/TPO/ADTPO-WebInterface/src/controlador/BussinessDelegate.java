package controlador;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.SolicitudCotizacion;


public class BussinessDelegate {

	//provisorio, llama al Facade
	public Cliente getCliente(int idCliente) {
		Cliente c = new Cliente();
		c.setIdCliente(idCliente);
		c.setNombre("joaquin");
		c.setApellido("Attanasio");
		
		return c;
	}

	public void enviarSolicitudCotizacion(SolicitudCotizacion solicitud) {
		
		
	}

	
}
