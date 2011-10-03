package com.adtpo.admin.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModificarProveedor extends AbstractInternalFrame{

	private static final long serialVersionUID = -5917208785922770760L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	public ModificarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		setTitle("Modificar Proveedor");

		addField(lblNombre, nombre);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();
	}
}

