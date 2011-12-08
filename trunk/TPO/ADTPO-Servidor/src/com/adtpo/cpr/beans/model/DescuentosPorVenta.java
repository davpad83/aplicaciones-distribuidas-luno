package com.adtpo.cpr.beans.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity()
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING)

public abstract class DescuentosPorVenta extends Politicas{

	protected Date fechaInicio;
	protected Date fechaFin;
	protected float descuento;
	
	public DescuentosPorVenta(){
		//Empty
	}
	
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
