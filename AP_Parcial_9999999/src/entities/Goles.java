package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Goles implements Serializable{
	private static final long serialVersionUID = 1L;

@EmbeddedId private GolesId id;
private int Sentido;
public GolesId getId() {
	return id;
}
public void setId(GolesId id) {
	this.id = id;
}
public int getSentido() {
	return Sentido;
}
public void setSentido(int sentido) {
	Sentido = sentido;
}


}
