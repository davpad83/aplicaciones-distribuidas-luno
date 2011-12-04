package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Rodamientos")

public class Rodamiento implements Serializable{

	@Transient private static final long serialVersionUID = 1491704294592138043L;

	@EmbeddedId
	private RodamientoId idRodamiento;
	private int stock;
	
	public Rodamiento(){
		//Empty
	}
	
	public String getCodigo() {
		return this.getIdRodamiento().getCodigo();
	}

	public String getMarca() {
		return this.getIdRodamiento().getMarca();
	}

	public String getPais() {
		return this.getIdRodamiento().getPais();
	}
	
	public String getCaracteristica() {
		return this.getIdRodamiento().getCaracteristica();
	}
	
	
	public RodamientoId getIdRodamiento() {
		return idRodamiento;
	}

	public void setIdRodamiento(RodamientoId idRodamiento) {
		this.idRodamiento = idRodamiento;
	}

	public Rodamiento(String codigo,String marca, String caracteristicas, String origen){
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void ingresoStock (float precio, Integer cantidad){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRodamiento == null) ? 0 : idRodamiento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rodamiento other = (Rodamiento) obj;
		if (idRodamiento == null) {
			if (other.idRodamiento != null)
				return false;
		} else if (!idRodamiento.equals(other.idRodamiento))
			return false;
		return true;
	}
}

