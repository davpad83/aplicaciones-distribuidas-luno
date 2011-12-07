package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class MapaRodamientoPrecio implements Serializable {

	@Transient
	private static final long serialVersionUID = -8355235279945763599L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMapaRodamientoPrecio;

	@OneToOne
	@JoinColumns( {
			@JoinColumn(name = "codigo_fk", referencedColumnName = "codigo", updatable = false),
			@JoinColumn(name = "marca_fk", referencedColumnName = "marca", updatable = false),
			@JoinColumn(name = "caracteristica_fk", referencedColumnName = "caracteristica", updatable = false),
			@JoinColumn(name = "pais_fk", referencedColumnName = "pais", updatable = false) })
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMapaRodamientoPrecio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapaRodamientoPrecio other = (MapaRodamientoPrecio) obj;
		if (idMapaRodamientoPrecio != other.idMapaRodamientoPrecio)
			return false;
		return true;
	}
}
