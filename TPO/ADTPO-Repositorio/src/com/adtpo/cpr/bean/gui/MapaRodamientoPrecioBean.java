package com.adtpo.cpr.bean.gui;

import java.io.Serializable;

public class MapaRodamientoPrecioBean implements Serializable{
	
	private static final long serialVersionUID = 2285997821471862674L;

	private RodamientoBean rodamiento;
	private float precio;
	
	public MapaRodamientoPrecioBean(){
		//empty
	}

	public MapaRodamientoPrecioBean(RodamientoBean a, float f) {
		this.precio = f;
		this.rodamiento= a;
	}

	public RodamientoBean getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoBean rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rodamiento == null) ? 0 : rodamiento.hashCode());
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
		MapaRodamientoPrecioBean other = (MapaRodamientoPrecioBean) obj;
		if (rodamiento == null) {
			if (other.rodamiento != null)
				return false;
		} else if (!rodamiento.equals(other.rodamiento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MapaRodamientoPrecioBean \n[precio=" + precio
				+ ", \nrodamiento=" + rodamiento + "]";
	}
}
