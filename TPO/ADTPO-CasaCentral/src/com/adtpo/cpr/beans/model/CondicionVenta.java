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
}
