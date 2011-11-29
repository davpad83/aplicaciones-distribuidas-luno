package com.adtpo.cpr.beans.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PG")

public class PorcentajeGanancia extends Politicas{

	private float porcentaje;
	
	public PorcentajeGanancia(){
		//empty
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public void recalcularPorcentaje(){
		
	}
}
