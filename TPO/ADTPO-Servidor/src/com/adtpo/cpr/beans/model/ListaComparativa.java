package com.adtpo.cpr.beans.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

@Entity
public class ListaComparativa implements Serializable {

	@Transient private static final long serialVersionUID = 8157901730509347675L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idListaComparativa;
	
	private Date fechaLista;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idListaComparativa")
	private List<ItemListaComparativa> items;
	
	public Date getFechaLista() {
		return fechaLista;
	}
	
	public void setFechaLista(Date fechaLista) {
		this.fechaLista = fechaLista;
	}
	
	public List<ItemListaComparativa> getItems() {
		return items;
	}
	
	public void setItems(List<ItemListaComparativa> items) {
		this.items = items;
	}
	
	public ListaComparativa(){
		//Empty
	}
	
	public void setIdListaComparativa(int idListaComparativa) {
		this.idListaComparativa = idListaComparativa;
	}

	public int getIdListaComparativa() {
		return idListaComparativa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idListaComparativa;
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
		ListaComparativa other = (ListaComparativa) obj;
		if (idListaComparativa != other.idListaComparativa)
			return false;
		return true;
	}
}
