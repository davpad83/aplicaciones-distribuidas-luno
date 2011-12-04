package com.adtpo.cpr.bean.gui;

import java.io.Serializable;

public class ItemRodamientoBean implements Serializable{
	
	private static final long serialVersionUID = -5909359044257142718L;
	
	private int cantidad;
	private RodamientoBean rodamiento;
	private float precio;
	private ProveedorBean proveedor;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public ProveedorBean getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorBean proveedor) {
		this.proveedor = proveedor;
	}

}
