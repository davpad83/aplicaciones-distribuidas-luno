package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;


@Entity
@Table (name="Ventas")

public class Venta implements Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVenta;
	private Cotizacion cotizacion;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	
	public Cotizacion getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}
}
