package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Proveedor implements Serializable {
	
	@Transient private static final long serialVersionUID = -9007618239954095860L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProveedor;
	
	private String cuit;
	private String nombre;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ListasProveedor> listas = new ArrayList<ListasProveedor>();
	
	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProveedor;
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
		Proveedor other = (Proveedor) obj;
		if (idProveedor != other.idProveedor)
			return false;
		return true;
	}

	public void setListas(List<ListasProveedor> listas) {
		this.listas = listas;
	}

	public List<ListasProveedor> getListas() {
		return listas;
	}
}
