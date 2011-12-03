package com.adtpo.cpr.beans.model;

import javax.persistence.*;


@Embeddable

public class ItemRodamiento {
	
	private int cantidad;
	private Rodamiento rodamiento;
	private double precio;
	private Proveedor proveedor;
	
	
	
	public ItemRodamiento() {
	
	}
	
	public ItemRodamiento( Rodamiento rodamiento, int cantidad) {
		this.cantidad = cantidad;
		this.rodamiento = rodamiento;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
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
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	
}
