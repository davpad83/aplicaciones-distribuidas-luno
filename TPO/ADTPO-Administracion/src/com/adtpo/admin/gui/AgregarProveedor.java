package com.adtpo.admin.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarProveedor extends AbstractInternalFrame{
	
	private static final long serialVersionUID = -3222937216293640414L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	public AgregarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Agregar Proveedor");
		
		addField(lblNombre, nombre);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
	}
}
