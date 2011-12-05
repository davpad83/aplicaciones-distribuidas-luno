package com.adtpo.cpr.bean.gui;

import java.io.Serializable;

public class CondicionVentaBean implements Serializable{
	
	private static final long serialVersionUID = 8039571559408529543L;

	private int idCondicion;	
	private String tipo;
	private Float interes;
	private int CantidadDiasDePago;
	private float descuento;
	public CondicionVentaBean(){
		//empty
	}

	public int getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
	}

	public int getCantidadDiasDePago() {
		return CantidadDiasDePago;
	}

	public void setCantidadDiasDePago(int cantidadDiasDePago) {
		CantidadDiasDePago = cantidadDiasDePago;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
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

}
