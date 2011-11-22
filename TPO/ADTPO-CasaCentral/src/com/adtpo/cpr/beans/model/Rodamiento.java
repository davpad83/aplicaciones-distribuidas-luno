package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.*;



@Entity
@Table(name="Rodamientos")

public class Rodamiento implements Serializable{

	@Id private String codigo;
	private String marca;
	private String caracteristica;
	private String origen;
	private float precioUnitario;
	private Integer stock;
	private boolean marcaAlternativa;
	
	
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
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
