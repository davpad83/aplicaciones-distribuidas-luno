package com.adtpo.cpr.beans.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PCP")
public class PolPagoCortoPlazo extends DescuentosPorVenta {

	private int cantDiasMinimos;

	@Override
	public float calcularDescuento(Rodamiento rodamiento, int cantidad,
			String metodoPago, int cantDiasDePago) {
		// TODO calcularDescuento cantDiasMinimos
		return 0;
	}

	public void setCantDiasMinimos(int cantDiasMinimos) {
		this.cantDiasMinimos = cantDiasMinimos;
	}

	public int getCantDiasMinimos() {
		return cantDiasMinimos;
	}

}
