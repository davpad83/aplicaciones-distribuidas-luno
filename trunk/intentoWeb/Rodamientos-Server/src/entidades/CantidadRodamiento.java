package entidades;

import java.io.Serializable;

public class CantidadRodamiento implements Serializable
{
	private static final long serialVersionUID = -2614718373657881211L;
	
	private Rodamiento rodamiento ;
	private String cantidad ;
	
	public CantidadRodamiento (Rodamiento rod, String cant){
		this.rodamiento = rod;
		this.cantidad = cant;
	}
	
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	
}
