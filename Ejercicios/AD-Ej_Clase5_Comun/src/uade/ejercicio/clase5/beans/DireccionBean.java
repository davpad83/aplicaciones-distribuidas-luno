package uade.ejercicio.clase5.beans;

import java.io.Serializable;

public class DireccionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -113293396586873948L;
	private String calle;
	private int numero;
	private String cp;
	private String localidad;
	private int piso;
	private String depto;
		
	public DireccionBean() {
		//empty
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	
	public boolean equals(DireccionBean d){
		if(this.calle == d.calle && this.numero == d.numero && this.cp == d.cp){
			if(this.depto.isEmpty()){
				return true;
			}else{
				if(this.piso == d.piso && this.depto == d.depto){
					return true;
				}else{
					return false;
				}
			}
		}else{
			return false;
		}
	}
	
	public String toString(){
		return "Calle: "+calle+"\nNumero: "+numero+"\nCodigo postal: "+cp+"\nLocalidad: "
		+localidad+"\nPiso: "+piso+"Departamento: "+depto;
	}
	

}
