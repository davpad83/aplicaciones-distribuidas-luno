package com.adtpo.ov.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ModificarCliente extends AbstractInternalFrame{

	private static final long serialVersionUID = -4553475305493550346L;
	
	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblApellido = new JLabel("Apellido"+lblSpace);
	private JTextField apellido = new JTextField();
	
	private JLabel lblTelefono = new JLabel("Telefono"+lblSpace);
	private JTextField telefono = new JTextField();
	
	private JLabel lblEmail = new JLabel("Email"+lblSpace);
	private JTextField email = new JTextField();
	
	public ModificarCliente(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Modificar Cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		center.add(buscar);
		center.add(new JSeparator());
		addField(lblNombre, nombre);
		addField(lblApellido, apellido);
		addField(lblTelefono, telefono);
		addField(lblEmail, email);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();
		
	}
}
