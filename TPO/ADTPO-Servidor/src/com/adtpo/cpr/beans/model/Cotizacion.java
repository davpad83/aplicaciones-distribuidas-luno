package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity

public class Cotizacion implements Serializable {

	@Transient private static final long serialVersionUID = -4436246431980549144L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idCotizacion;
	private Date vencimiento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	private float iva;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idCotizacion")
	private List<ItemRodamiento> items;
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
	public void registrarVencimiento() {
		//Obtiene la fecha del sistema
		Calendar c1 = Calendar.getInstance(); 
		c1.add(Calendar.DATE,30); //le suma 30 dias
		this.vencimiento=c1.getTime() ;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemRodamiento> getItems() {
		return items;
	}
	
	public void setItems(List<ItemRodamiento> items) {
		this.items = items;
	}
	
	public boolean isAprobada() {
		return aprobada;
	}
	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}
	
	/**
	 * Obtiene el total de la cotizacion mas el aumento por el IVA
	 * 
	 * @return float total
	 */
	public float getTotal(){
		Cotizacion c = CasaCentral.getInstancia().getCotizacion(idCotizacion);
		return c.getTotal()*(1+iva);
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getIva() {
		return iva;
	}

	public void setVencimiento(Date vencimiento2) {
		this.vencimiento=vencimiento2;
		
	}
}
