package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

import com.adtpo.cpr.bean.gui.DomicilioBean;

@Entity
@Table(name="Cliente")

public class Cliente implements Serializable {
	
	@Transient private static final long serialVersionUID = 7715087270966509277L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;
	
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;

	@Embedded
	private DomicilioBean domicilio;

	@OneToMany(cascade = CascadeType.ALL)
	private ArrayList<CondicionVenta> condicion;

	public int getId() {
		return idCliente;
	}

	public void setId(int id) {
		this.idCliente = id;
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

	public ArrayList<CondicionVenta> getCondicion() {
		return condicion;
	}

	public void setCondicion(ArrayList<CondicionVenta> condicion) {
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
