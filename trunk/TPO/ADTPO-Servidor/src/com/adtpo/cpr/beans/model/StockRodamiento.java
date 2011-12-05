package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class StockRodamiento implements Serializable{
	
	@Transient private static final long serialVersionUID = 4479344403769022879L;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})
	private Rodamiento rodamiento;
	private int stock;

	public StockRodamiento(){
		//Empty
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rodamiento == null) ? 0 : rodamiento.hashCode());
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
		StockRodamiento other = (StockRodamiento) obj;
		if (rodamiento == null) {
			if (other.rodamiento != null)
				return false;
		} else if (!rodamiento.equals(other.rodamiento))
			return false;
		return true;
	}
}
