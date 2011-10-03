package com.adtpo.admin.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EliminarCliente extends AbstractInternalFrame{

	private static final long serialVersionUID = 6752927912365539767L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblApellido = new JLabel("Apellido"+lblSpace);
	private JTextField apellido = new JTextField();
	
	public EliminarCliente(){
		super();
		initGUI();
	}

	public void initGUI(){
		setTitle("Eliminar cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		addField(lblNombre, nombre);
		
		addField(lblApellido, apellido);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();		
	}
}
