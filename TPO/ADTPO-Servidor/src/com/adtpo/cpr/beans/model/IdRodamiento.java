package com.adtpo.cpr.beans.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable()
class IdRodamiento implements Serializable{

	@Transient private static final long serialVersionUID = 2126413747984703362L;
	
	private String codigo;
	private String marca;
	private String pais;
	private String caracteristica;
	
	public IdRodamiento(){
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

