package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class Jugadores implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId IdJugador id;
	private String Nombre;
	private Date Fecha_Nac;
	
	@ManyToOne
	@JoinColumn(name = "id_club")
	private Clubes club;

	public IdJugador getId() {
		return id;
	}

	public void setId(IdJugador id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getFecha_Nac() {
		return Fecha_Nac;
	}

	public void setFecha_Nac(Date fecha_Nac) {
		Fecha_Nac = fecha_Nac;
	}

	public Clubes getClub() {
		return club;
	}

	public void setClub(Clubes club) {
		this.club = club;
	}

	
}
