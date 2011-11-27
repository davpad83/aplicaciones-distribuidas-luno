package com.adtpo.cpr.beans.model;

public class PolPagoCortoPlazo extends DescuentosPorVenta{
	
	private int cantDiasMinimos;
	@Override
	public float calcularDescuento(Rodamiento rodamiento, int cantidad,
			String metodoPago, int cantDiasDePago) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setCantDiasMinimos(int cantDiasMinimos) {
		this.cantDiasMinimos = cantDiasMinimos;
	}
	public int getCantDiasMinimos() {
		return cantDiasMinimos;
	}
	
	
}
