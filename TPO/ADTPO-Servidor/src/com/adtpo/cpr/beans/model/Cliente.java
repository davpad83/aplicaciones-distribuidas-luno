package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cliente implements Serializable {
	
	@Transient private static final long serialVersionUID = 7715087270966509277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;

	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<CondicionVenta> condicion;

	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CondicionVenta> getCondicion() {
		return condicion;
	}

	public void setCondicion(List<CondicionVenta> condicion) {
		this.condicion = condicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCliente;
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
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		return true;
	}
}
