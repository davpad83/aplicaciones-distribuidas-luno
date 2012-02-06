package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Faltas implements Serializable{
	private static final long serialVersionUID = 1L;
@EmbeddedId FaltasId id;
public String tipo;
public FaltasId getId() {
	return id;
}
public void setId(FaltasId id) {
	this.id = id;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}


	
}
