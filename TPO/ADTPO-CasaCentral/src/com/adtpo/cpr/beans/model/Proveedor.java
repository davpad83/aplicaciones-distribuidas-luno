package com.adtpo.cpr.beans.model;

import javax.persistence.*;

@Entity
public class Proveedor {

	@Id private String cuit;
	private String nombre;
	
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
