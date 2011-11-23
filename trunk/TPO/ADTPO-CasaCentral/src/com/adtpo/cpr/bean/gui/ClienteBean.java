package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.ArrayList;

public class ClienteBean implements Serializable{
	 
	private static final long serialVersionUID = -2156390791805150000L;

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private ArrayList<CondicionVentaBean> condicion;
	
	public ClienteBean(){
		//empty
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

	public ArrayList<CondicionVentaBean> getCondicion() {
		return condicion;
	}

	public void setCondicion(ArrayList<CondicionVentaBean> condicion) {
		this.condicion = condicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		ClienteBean other = (ClienteBean) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteBean [apellido=" + apellido + ", email=" + email
				+ ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
}
