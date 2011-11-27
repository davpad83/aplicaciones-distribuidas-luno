package com.adtpo.cpr.beans.model;

public class VolumenVenta extends DescuentosPorVenta{
	private int cantidadMin;
	@Override
	public float calcularDescuento(Rodamiento rodamiento, int cantidad,
			String metodoPago, int cantDiasDePago) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setCantidadMin(int cantidadMin) {
		this.cantidadMin = cantidadMin;
	}
	public int getCantidadMin() {
		return cantidadMin;
	}

}
