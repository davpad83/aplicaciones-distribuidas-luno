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

	private ListasProveedor idListaProveedor;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumns( {
			@JoinColumn(name = "codigo_fk", referencedColumnName = "codigo"),
			@JoinColumn(name = "marca_fk", referencedColumnName = "marca"),
			@JoinColumn(name = "caracteristica_fk", referencedColumnName = "caracteristica"),
			@JoinColumn(name = "pais_fk", referencedColumnName = "pais") })
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

	public void setLista(ListasProveedor lista) {
		this.idListaProveedor = lista;
	}

	public ListasProveedor getLista() {
		return idListaProveedor;
	}
}
