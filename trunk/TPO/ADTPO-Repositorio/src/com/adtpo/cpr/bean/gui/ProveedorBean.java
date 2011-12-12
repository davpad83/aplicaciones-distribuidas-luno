package com.adtpo.cpr.bean.gui;

import java.io.Serializable;

public class ProveedorBean implements Serializable {

	private static final long serialVersionUID = -4879844830531413451L;

	private int id;
	private String cuit;
	private String nombre;

	public ProveedorBean(){
		//Empty
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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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
		ProveedorBean other = (ProveedorBean) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProveedorBean \n[cuit=" + cuit + ", \nid=" + id + ", \nnombre="
				+ nombre + "]";
	}
}
