package com.adtpo.admin.gui;

import sun.security.util.Password;

public class Login {
	
	private int id;
	private String usuario;
	private Password password;
	
	public Login(int id, String usuario, Password password){
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

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}	
}
