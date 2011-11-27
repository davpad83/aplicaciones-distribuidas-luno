package com.adtpo.cpr.beans.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Factura")

public class Factura {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFactura;
	private Venta Venta;
	private Date fechaFactura;
	
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public Venta getVenta() {
		return Venta;
	}
	public void setVenta(Venta venta) {
		Venta = venta;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

}
