package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Rodamientos")

public class Rodamiento implements Serializable, Comparable{

	private static final long serialVersionUID = 1491704294592138043L;

	@EmbeddedId
	private RodamientoId idRodamiento;
	
	private String caracteristica;
	private float precioUnitario;
	private Integer stock;
	private boolean marcaAlternativa;
	
	public Rodamiento(){
		//Empty
	}
	
	public Rodamiento(String codigo,String marca, String caracteristicas, String origen){
		this.caracteristica = caracteristicas;
	}
	
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public boolean isMarcaAlternativa() {
		return marcaAlternativa;
	}
	public void setMarcaAlternativa(boolean marcaAlternativa) {
		this.marcaAlternativa = marcaAlternativa;
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
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

@Embeddable()
class RodamientoId implements Serializable{

	private String codigo;
	private String marca;
	private String pais;
	
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
}

