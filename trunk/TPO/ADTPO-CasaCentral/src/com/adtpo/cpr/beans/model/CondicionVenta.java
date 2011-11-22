package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CondicionVenta")

public class CondicionVenta implements Serializable{
	
	@Transient private static final long serialVersionUID = 2506366175876298194L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCondicion;
	
	private String tipo;
	private int interes;
	private int descuento;
	
	public CondicionVenta(){
		//EMPTY
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getInteres() {
		return interes;
	}

	public void setInteres(int interes) {
		this.interes = interes;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getIdCondicion() {
		return idCondicion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCondicion;
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
		CondicionVenta other = (CondicionVenta) obj;
		if (idCondicion != other.idCondicion)
			return false;
		return true;
	}
	
}
