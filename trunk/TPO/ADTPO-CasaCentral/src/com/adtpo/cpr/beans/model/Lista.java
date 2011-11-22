package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Lista implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idLista;
	private String nombre;
	private int descuento;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLista")
	private ArrayList<Proveedor> proveedores;

	@OneToMany
	@JoinColumn(name = "idLista")
	public ArrayList<CondicionVenta> condVenta;

	private Map<Rodamiento, Float> listaRodamientos;

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

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public ArrayList<Proveedor> getProveedor() {
		return proveedores;
	}

	public void setProveedor(ArrayList<Proveedor> proveedor) {
		this.proveedores = proveedor;
	}

	public List<CondicionVenta> getCondVenta() {
		return condVenta;
	}

	public void setCondVenta(ArrayList<CondicionVenta> condVenta) {
		this.condVenta = condVenta;
	}

	public void setListaRodamientos(Map<Rodamiento, Float> listaRodamientos) {
		this.listaRodamientos = listaRodamientos;
	}

	public Map<Rodamiento, Float> getListaRodamientos() {
		return listaRodamientos;
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
		Lista other = (Lista) obj;
		if (idLista != other.idLista)
			return false;
		return true;
	}

}
