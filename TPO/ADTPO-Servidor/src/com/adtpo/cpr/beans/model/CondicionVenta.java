package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="CondicionVenta")
public class CondicionVenta implements Serializable{
	
	@Transient private static final long serialVersionUID = 2506366175876298194L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCondicion;
	
	private String tipo;
	private Float interes;
	private int CantidadDiasDePago;
	private float descuento;
	
	public CondicionVenta(){
		//EMPTY
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

	public int getIdCondicion() {
		return idCondicion;
	}
	
	public void setIdCondicion(int idCondicion) {
		this.idCondicion = idCondicion;
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

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setCantidadDiasDePago(int cantidadDiasDePago) {
		CantidadDiasDePago = cantidadDiasDePago;
	}

	public int getCantidadDiasDePago() {
		return CantidadDiasDePago;
	}
	
}
