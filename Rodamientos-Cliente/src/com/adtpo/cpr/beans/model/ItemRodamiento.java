package com.adtpo.cpr.beans.model;

import javax.persistence.*;


@Embeddable

public class ItemRodamiento {
	
	private int cantidad;
	private Rodamiento rodamiento;
	
	public ItemRodamiento(){
		
	}
	
	public ItemRodamiento( Rodamiento rod,int cantidad){
		this.cantidad=cantidad;
		this.rodamiento=rod;
		
	}
	
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
	
	
	
}
