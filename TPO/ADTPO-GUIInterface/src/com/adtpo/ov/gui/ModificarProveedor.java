package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ModificarProveedor extends AbstractInternalFrame{

	private static final long serialVersionUID = -5917208785922770760L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblCondiciones = new JLabel("Condiciones"+lblSpace);
	private JTextField condiciones = new JTextField();
	
	public ModificarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		setTitle("Modificar Proveedor");

		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		addField(lblId, id);		
		center.add(buscar);
		center.add(new JSeparator());
		
		addField(lblNombre, nombre);
		addField(lblCondiciones,condiciones);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		validate();
		pack();
	}
}

