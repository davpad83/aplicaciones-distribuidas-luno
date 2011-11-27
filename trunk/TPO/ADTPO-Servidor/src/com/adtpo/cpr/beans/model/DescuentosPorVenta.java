package com.adtpo.cpr.beans.model;

import java.util.Date;

public abstract class DescuentosPorVenta extends Politicas{

	private Date fechaInicio;
	private Date fechaFin;
	private float descuento;
	
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
	
	public abstract float calcularDescuento (Rodamiento rodamiento, int cantidad, String metodoPago, int cantDiasDePago);
}
