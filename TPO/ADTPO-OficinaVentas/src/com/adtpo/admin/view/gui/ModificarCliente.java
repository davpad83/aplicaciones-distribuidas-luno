package com.adtpo.admin.view.gui;

import javax.swing.JLabel;
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

	private JLabel lblCalle = new JLabel("Calle"+lblSpace);
	private JTextField calle = new JTextField();
	
	private JLabel lblNumero = new JLabel("Numero"+lblSpace);
	private JTextField numero = new JTextField();
	
	private JLabel lblPiso  = new JLabel("Piso"+lblSpace);
	private JTextField piso = new JTextField();
	
	private JLabel lblDepto = new JLabel("Departamento"+lblSpace);
	private JTextField depto = new JTextField();
	
	private JLabel lblLocalidad = new JLabel("Localidad"+lblSpace);
	private JTextField localidad = new JTextField();

	public ModificarCliente(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Modificar Cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		
		addField(lblNombre, nombre);
		addField(lblApellido, apellido);
		addField(lblTelefono, telefono);
		addField(lblEmail, email);
		addField(lblCalle, calle);
		addField(lblNumero, numero);
		addField(lblPiso, piso);
		addField(lblDepto, depto);
		addField(lblLocalidad, localidad);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();
		
	}
}
