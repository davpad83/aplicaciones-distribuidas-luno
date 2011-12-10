package com.adtpo.cpr.bean.gui;

import java.io.Serializable;
import java.util.Date;

public class FacturaBean implements Serializable{

	private static final long serialVersionUID = -2883957106315507031L;

	private int idFactura;
	private VentaBean venta;
	private Date fechaFactura;
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public VentaBean getVenta() {
		return venta;
	}
	public void setVenta(VentaBean venta) {
		venta = venta;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	
	public float calcularTotal(){
		return venta.calcularTotal();
	}
	
}
