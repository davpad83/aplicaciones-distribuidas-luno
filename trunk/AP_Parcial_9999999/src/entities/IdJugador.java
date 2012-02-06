package entities;

import javax.persistence.Embeddable;

@Embeddable
public class IdJugador {
	private String tipoDoc;
	private int nroDoc;
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public int getNroDoc() {
		return nroDoc;
	}
	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}
	
	
	
}
