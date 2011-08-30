package uade.ejercicio.clase4.beans;

public class DireccionView {
	
	private String calle;
	private int numero;
	private String cp;
	private String localidad;
	private int piso;
	private String depto;
		
	public DireccionView(String calle, int numero, String cp, String localidad,
			int piso, String depto) {
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
		this.localidad = localidad;
		this.piso = piso;
		this.depto = depto;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getPeso() {
		return piso;
	}
	public void setPeso(int piso) {
		this.piso = piso;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	

}
