package com.adtpo.ov.gui;

public class Login {
	
	private int id;
	private String usuario;
	private String password;
	
	public Login(int id, String usuario, String password){
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
