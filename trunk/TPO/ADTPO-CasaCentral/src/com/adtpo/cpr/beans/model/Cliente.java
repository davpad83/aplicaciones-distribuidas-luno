package com.adtpo.cpr.beans.model;

import javax.persistence.*;

import com.adtpo.cpr.bean.gui.DomicilioBean;

@Entity
@Table(name="Cliente")

public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	
	@Embedded
	private DomicilioBean domicilio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "condicionVtaId")
	private CondicionVenta condicion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public DomicilioBean getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioBean domicilio) {
		this.domicilio = domicilio;
	}

	public CondicionVenta getCondicion() {
		return condicion;
	}

	public void setCondicion(CondicionVenta condicion) {
		this.condicion = condicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
}
