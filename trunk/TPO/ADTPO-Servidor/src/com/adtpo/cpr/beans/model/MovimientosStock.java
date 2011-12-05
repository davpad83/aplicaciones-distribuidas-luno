package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
public class MovimientosStock implements Serializable {
	
	@Transient private static final long serialVersionUID = -5560429643252501020L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idMovimiento;
	private Date fecha;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="codigo_fk", referencedColumnName="codigo"),
		@JoinColumn(name="marca_fk", referencedColumnName="marca"),
		@JoinColumn(name="caracteristica_fk", referencedColumnName="caracteristica"),
		@JoinColumn(name="pais_fk", referencedColumnName="pais")})
	private Rodamiento rodamiento;
	
	private String detalle;
	private double cantidadModificada;
	private int saldoCantidad;

	public MovimientosStock(){
		//Empty
	}

	public Date getFecha() {
		return fecha;
	}

	public void registrarFecha() {
		this.fecha = Calendar.getInstance().getTime();
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getCantidadModificada() {
		return cantidadModificada;
	}

	public void setCantidadModificada(double cantidadModificada) {
		this.cantidadModificada = cantidadModificada;
	}

	public int getSaldoCantidad() {
		return saldoCantidad;
	}

	public void setSaldoCantidad(int saldoCantidad) {
		this.saldoCantidad = saldoCantidad;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMovimiento;
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
		MovimientosStock other = (MovimientosStock) obj;
		if (idMovimiento != other.idMovimiento)
			return false;
		return true;
	}
}
