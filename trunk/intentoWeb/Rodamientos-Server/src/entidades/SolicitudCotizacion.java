package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SolicitudCotizacion implements Serializable
{
	private static final long serialVersionUID = 7068820790993609615L;
	
	private List<CantidadRodamiento> rodamientos ;

	public SolicitudCotizacion (){
		super();
		this.rodamientos = new ArrayList<CantidadRodamiento>();
	}
	
	public List<CantidadRodamiento> getRodamientos() {
		return rodamientos;
	}

	public void setRodamientos(List<CantidadRodamiento> rodamientos) {
		this.rodamientos = rodamientos;
	}
	
	public void agregarRodamiento (CantidadRodamiento rod) {
		this.rodamientos.add(rod);
	}
	
}
