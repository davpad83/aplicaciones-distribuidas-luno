package com.adtpo.cpr.beans.model;

import java.util.Date;

public class DescuentosPorVenta extends Politicas{

	private Date fechaInicio;
	private Date fechaFin;
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public float calcularDescuento (double monto){
		float descuento = 0;
		return descuento;
	}
}
