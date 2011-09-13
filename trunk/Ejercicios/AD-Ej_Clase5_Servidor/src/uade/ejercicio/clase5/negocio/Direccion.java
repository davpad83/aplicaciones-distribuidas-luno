package uade.ejercicio.clase5.negocio;

import uade.ejercicio.clase5.beans.DireccionBean;

public class Direccion {
	
	private String calle;
	private int numero;
	private String cp;
	private String localidad;
	private int piso;
	private String depto;
		
	public Direccion(String calle, int numero, String cp, String localidad,
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
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	
	public DireccionBean toBean(){
		DireccionBean db = new DireccionBean();
		db.setCalle(this.getCalle());
		db.setCp(this.getCp());
		db.setDepto(this.getDepto());
		db.setLocalidad(this.getLocalidad());
		db.setNumero(this.getNumero());
		db.setPiso(this.getPiso());
		return db;
	}
}
