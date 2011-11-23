package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EliminarCliente extends AbstractInternalFrame{

	private static final long serialVersionUID = 6752927912365539767L;
	
	public EliminarCliente(){
		super();
		initGUI();
	}

	public void initGUI(){
		setTitle("Eliminar cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				events.eliminarCliente(Integer.valueOf(id.getText()));
			}
		});
		
		validate();
		pack();		
	}
}
