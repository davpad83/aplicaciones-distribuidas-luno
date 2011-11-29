package com.adtpo.cpr.beans.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING)

public class Politicas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPolitica;
	
	private String nombre;

	public Integer getIdPolitica() {
		return idPolitica;
	}

	public void setIdPolitica(Integer idPolitica) {
		this.idPolitica = idPolitica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
