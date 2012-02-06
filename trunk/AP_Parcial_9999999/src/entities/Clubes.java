package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Clubes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private int Id_Club;
	private String nombre;
	private int Nrozona;
	
	//Jugadores
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn  (name = "idClub")
	private Set<Jugadores> jugadores = new HashSet<Jugadores>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idClubL")
	private Set<Partidos> locales = new HashSet<Partidos>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idClubV")
	private Set<Partidos> visitantes = new HashSet<Partidos>();

	public int getId_Club() {
		return Id_Club;
	}

	public void setId_Club(int id_Club) {
		Id_Club = id_Club;
	}

	public Set<Partidos> getLocales() {
		return locales;
	}

	public void setLocales(Set<Partidos> locales) {
		this.locales = locales;
	}

	public Set<Partidos> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(Set<Partidos> visitantes) {
		this.visitantes = visitantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNrozona() {
		return Nrozona;
	}

	public void setNrozona(int nrozona) {
		Nrozona = nrozona;
	}

	public Set<Jugadores> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugadores> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
	
}
