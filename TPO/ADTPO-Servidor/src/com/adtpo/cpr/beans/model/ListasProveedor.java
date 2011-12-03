package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class ListasProveedor implements Serializable {

	@Transient private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLista;

	private String nombre;
	private float descuento;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idProveedor")
	private Proveedor proveedores;
	
	@ManyToMany
	@JoinColumn(referencedColumnName="idRodamiento")
	private Map<Rodamiento, Float> Rodamientos;

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public Proveedor getProveedor() {
		return proveedores;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedores = proveedor;
	}

	public void setListaRodamientos(Map<Rodamiento, Float> listaRodamientos) {
		this.Rodamientos = listaRodamientos;
	}

	public Map<Rodamiento, Float> getListaRodamientos() {
		return Rodamientos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLista;
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
		ListasProveedor other = (ListasProveedor) obj;
		if (idLista != other.idLista)
			return false;
		return true;
	}

}
