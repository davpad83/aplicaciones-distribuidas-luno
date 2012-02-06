package entities;

import javax.persistence.Embeddable;

@Embeddable
public class FaltasId {
private Jugadores jugador;
private Partidos partido;
private int minuto;
public Partidos getPartido() {
	return partido;
}
public void setPartido(Partidos partido) {
	this.partido = partido;
}
public int getMinuto() {
	return minuto;
}
public void setMinuto(int minuto) {
	this.minuto = minuto;
}

public String getTipoDoc(){
	return this.jugador.id.getTipoDoc();
}
public int getNroDoc(){
	return this.jugador.id.getNroDoc();
}
public void setJugador(Jugadores jugador) {
	this.jugador = jugador;
}

}
