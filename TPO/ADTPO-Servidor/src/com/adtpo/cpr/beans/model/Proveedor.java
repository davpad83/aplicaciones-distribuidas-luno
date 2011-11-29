package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Proveedor")
@NamedQuery(name="NombresProve", query="Select cuit, nombre from Proveedor")

public class Proveedor implements Serializable {
	
	@Transient private static final long serialVersionUID = -9007618239954095860L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProveedor;
	
	@Column(nullable=false, length=14)
	private String cuit;
	
	@Column(nullable =true, length=30)
	private String nombre;

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
}