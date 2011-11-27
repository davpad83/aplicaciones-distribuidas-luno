package com.adtpo.cpr.beans.model;

public class PorcentajeGanancia extends DescuentosPorVenta{

	private float porcentaje;

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public void recalcularPorcentaje(){
		
	}

	@Override
	public float calcularDescuento(Rodamiento rodamiento, int cantidad,
			String metodoPago, int cantDiasDePago) {
		// TODO Auto-generated method stub
		return 0;
	}

}
