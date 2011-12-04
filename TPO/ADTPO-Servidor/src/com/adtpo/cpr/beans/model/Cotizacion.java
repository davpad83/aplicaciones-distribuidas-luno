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
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idCotizacion;
	private Date vencimiento;
	private Cliente cliente;
	private float iva;
	
	@Embedded
	private ArrayList<ItemRodamiento> items;
	private boolean aprobada;
	
	public int getIdCotizazion() {
		return idCotizacion;
	}
	
	public void setIdCotizazion(int idCotizazion) {
		this.idCotizacion = idCotizazion;
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

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getIva() {
		return iva;
	}

	public ArrayList<ItemRodamiento> calcularPreciosItems(
			ArrayList<ItemRodamiento> items) {
		
		return null;
	}
}
