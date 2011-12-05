package com.adtpo.cpr.beans.model;

public class PolPagoContado extends DescuentosPorVenta{

	public PolPagoContado(){
		super();
	}
	
	@Override
	public float calcularDescuento(Rodamiento rodamiento, int cantidad,
			String metodoPago, int cantDiasDePago) {
		if(metodoPago=="Contado"){
			return descuento;	
		}
		return 0;
	}
}
