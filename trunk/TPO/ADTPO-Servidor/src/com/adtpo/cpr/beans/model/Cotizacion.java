package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table (name="Cotizaciones")

public class Cotizacion implements Serializable {

	@Transient private static final long serialVersionUID = -4436246431980549144L;
	
	@Id @GeneratedValue
	private int idCotizazion;
	private Date vencimiento;
	private Cliente cliente;
	private Float iva;
	
	@Embedded
	private ArrayList<ItemRodamiento> items;
	private boolean aprobada;
	
	public int getIdCotizazion() {
		return idCotizazion;
	}
	
	public void setIdCotizazion(int idCotizazion) {
		this.idCotizazion = idCotizazion;
	}
	
	public Date getVencimiento() {
		return vencimiento;
	}
	/**
	 * devuelve una vigencia de 30 dias
	 */
	public void setVencimiento() {
		SimpleDateFormat formato = new SimpleDateFormat	("dd/MM/yyyy");
		//Obtiene la fecha del sistema
		Calendar c1 = Calendar.getInstance(); 
		c1.add(Calendar.DATE,30); //le suma 30 días
		this.vencimiento=c1.getTime() ;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<ItemRodamiento> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<ItemRodamiento> items) {
		this.items = items;
	}
	
	public boolean isAprobada() {
		return aprobada;
	}
	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}
	
	public float getTotal(){
		return -1;
		//TODO codigo
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCotizazion == null) ? 0 : idCotizazion.hashCode());
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
		Cotizacion other = (Cotizacion) obj;
		if (idCotizazion == null) {
			if (other.idCotizazion != null)
				return false;
		} else if (!idCotizazion.equals(other.idCotizazion))
			return false;
		return true;
	}

	public void setIva(Float iva) {
		this.iva = iva;
	}

	public Float getIva() {
		return iva;
	}
}
