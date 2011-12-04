package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ItemListaComparativa implements Serializable {

	@Transient private static final long serialVersionUID = -314067622085452275L;

	private Rodamiento rodamiento;
	private float precio;	
	private ListasProveedor listaProveedor;
	
	public ItemListaComparativa(){
		//Empty
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
	public ListasProveedor getListaProveedor() {
		return listaProveedor;
	}
	public void setListaProveedor(ListasProveedor listaProveedor) {
		this.listaProveedor = listaProveedor;
	}
}
