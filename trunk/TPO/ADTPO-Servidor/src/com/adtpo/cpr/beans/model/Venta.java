package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;


@Entity
public class Venta implements Serializable {

	@Transient private static final long serialVersionUID = -2440932116522255416L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVenta;
	
	@OneToOne
	@JoinColumn(name="idCotizacion")
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
