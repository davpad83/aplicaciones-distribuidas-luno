package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity

public class CondicionVenta implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String tipo;
	private int interes;
	private int descuento;
	
	public CondicionVenta(){
		//EMPTY
	}

	
}
