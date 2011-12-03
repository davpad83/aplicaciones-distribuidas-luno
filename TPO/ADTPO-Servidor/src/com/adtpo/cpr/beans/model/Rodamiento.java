package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Rodamientos")

public class Rodamiento implements Serializable, Comparable<Rodamiento>{

	@Transient private static final long serialVersionUID = 1491704294592138043L;

	@EmbeddedId
	private RodamientoId idRodamiento;
	private int stock;
	
	public Rodamiento(){
		//Empty
	}
	
	public RodamientoId getIdRodamiento() {
		return idRodamiento;
	}

	public void setIdRodamiento(RodamientoId idRodamiento) {
		this.idRodamiento = idRodamiento;
	}

	public Rodamiento(String codigo,String marca, String caracteristicas, String origen){
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void ingresoStock (float precio, Integer cantidad){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRodamiento == null) ? 0 : idRodamiento.hashCode());
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
		Rodamiento other = (Rodamiento) obj;
		if (idRodamiento == null) {
			if (other.idRodamiento != null)
				return false;
		} else if (!idRodamiento.equals(other.idRodamiento))
			return false;
		return true;
	}

	@Override
	public int compareTo(Rodamiento arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

@Embeddable()
class RodamientoId implements Serializable{

	@Transient private static final long serialVersionUID = 2126413747984703362L;
	
	private String codigo;
	private String marca;
	private String pais;
	private String caracteristica;
	
	public RodamientoId(){
		//Empty
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}
	
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}

