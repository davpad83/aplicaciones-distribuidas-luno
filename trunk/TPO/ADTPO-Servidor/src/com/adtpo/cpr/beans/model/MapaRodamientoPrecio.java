package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class MapaRodamientoPrecio implements Serializable{
	
	@Transient private static final long serialVersionUID = -8355235279945763599L;

	@OneToOne
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})	
	private Rodamiento rodamiento;
	
	private float precio;
	
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
