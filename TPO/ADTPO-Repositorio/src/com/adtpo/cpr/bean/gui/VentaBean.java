package com.adtpo.cpr.bean.gui;

import java.io.Serializable;


public class VentaBean implements Serializable{
	private static final long serialVersionUID = 8926176181147949860L;

	private int idVenta;
	private CotizacionBean cotizacion;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public CotizacionBean getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(CotizacionBean cotizacion) {
		this.cotizacion = cotizacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cotizacion == null) ? 0 : cotizacion.hashCode());
		result = prime * result + idVenta;
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
		VentaBean other = (VentaBean) obj;
		if (cotizacion == null) {
			if (other.cotizacion != null)
				return false;
		} else if (!cotizacion.equals(other.cotizacion))
			return false;
		if (idVenta != other.idVenta)
			return false;
		return true;
	}
	public float calcularTotal() {
		return cotizacion.calcularTotal();
		
	}

}
