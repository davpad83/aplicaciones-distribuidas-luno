package com.adtpo.admin.view.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EliminarProveedor extends AbstractInternalFrame{

	private static final long serialVersionUID = 1561047648206960604L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	public EliminarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		setTitle("Eliminar Proveedor");
		
		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		addField(lblId, id);
		addField(lblNombre, nombre);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();
	}
}
