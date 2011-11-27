package com.adtpo.cpr.beans.model;

import javax.persistence.Id;

public class Politicas {


	@Id private Integer idPolitica;
	private String nombre;
	public Integer getIdPolitica() {
		return idPolitica;
	}
	public void setIdPolitica(Integer idPolitica) {
		this.idPolitica = idPolitica;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
