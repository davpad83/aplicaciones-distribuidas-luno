package com.adtpo.cpr.beans.model;

import javax.persistence.*;


@Embeddable
public class ItemRodamiento {
	
	private int cantidad;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})	
	private Rodamiento rodamiento;
	private float precio;
	
	
	private Proveedor proveedor;
	
	public ItemRodamiento() {
		//Empty
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	
}
