package com.adtpo.cpr.bean.gui;

import java.io.Serializable;

public class CondicionVentaBean implements Serializable{
	
	private static final long serialVersionUID = 8039571559408529543L;

	private Integer idCondicion;	
	private String tipo;
	private Float interes;
	
	public CondicionVentaBean(){
		//empty
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getInteres() {
		return interes;
	}

	public void setInteres(Float interes) {
		this.interes = interes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCondicion == null) ? 0 : idCondicion.hashCode());
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
		CondicionVentaBean other = (CondicionVentaBean) obj;
		if (idCondicion == null) {
			if (other.idCondicion != null)
				return false;
		} else if (!idCondicion.equals(other.idCondicion))
			return false;
		return true;
	}
}
