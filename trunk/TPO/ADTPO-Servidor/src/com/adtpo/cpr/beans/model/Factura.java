package com.adtpo.cpr.beans.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Factura")

public class Factura {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFactura;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idVenta")
	private Venta Venta;
	
	private Date fechaFactura;
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
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
	public float calcularTotal(){
		return Venta.getCotizacion().getTotal();
	}

}
