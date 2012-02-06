package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class Partidos implements Serializable{
	private static final long serialVersionUID = 1L;

@Id private int Id_Partido;
private int nroFecha;
private int zona;
private int categoria;
private Date fecha;

@OneToMany
@JoinColumn(name = "IdClubL")
private Clubes local;

@OneToMany
@JoinColumn(name = "IdClubV")
private Clubes visitante;

private int golesLocal;
private int golesVisitante;
public int getId_Partido() {
	return Id_Partido;
}
public void setId_Partido(int id_Partido) {
	Id_Partido = id_Partido;
}
public int getNroFecha() {
	return nroFecha;
}
public void setNroFecha(int nroFecha) {
	this.nroFecha = nroFecha;
}
public int getZona() {
	return zona;
}
public void setZona(int zona) {
	this.zona = zona;
}
public int getCategoria() {
	return categoria;
}
public void setCategoria(int categoria) {
	this.categoria = categoria;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public Clubes getLocal() {
	return local;
}
public void setLocal(Clubes local) {
	this.local = local;
}
public Clubes getVisitante() {
	return visitante;
}
public void setVisitante(Clubes visitante) {
	this.visitante = visitante;
}
public int getGolesLocal() {
	return golesLocal;
}
public void setGolesLocal(int golesLocal) {
	this.golesLocal = golesLocal;
}
public int getGolesVisitante() {
	return golesVisitante;
}
public void setGolesVisitante(int golesVisitante) {
	this.golesVisitante = golesVisitante;
}


}
