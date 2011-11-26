package com.adtpo.cpr.beans.model;

import javax.persistence.*;


@Embeddable

public class ItemRodamientoPrecio {
	
	private int cantidad;
	private Rodamiento rodamiento;
	private double precio;
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
