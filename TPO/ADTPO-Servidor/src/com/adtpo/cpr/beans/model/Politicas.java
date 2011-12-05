package com.adtpo.cpr.beans.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator", discriminatorType=DiscriminatorType.STRING)

public class Politicas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer idPolitica;
	
	protected String nombre;

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
