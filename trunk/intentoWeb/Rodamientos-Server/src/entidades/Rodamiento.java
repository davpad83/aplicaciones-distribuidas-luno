package entidades;

import java.io.Serializable;

public class Rodamiento implements Serializable
{
	private static final long serialVersionUID = 1379802074229090395L;
	
	private String id ;
	private String codigo ;
	private String marca ;
	private String caracteristicas ;
	private String origen ;
	
	public Rodamiento (String cod, String mar, String carac, String ori){
		this.codigo = cod;
		this.marca = mar;
		this.caracteristicas = carac;
		this.origen = ori;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
}
