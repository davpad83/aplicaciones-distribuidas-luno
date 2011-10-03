package com.adtpo.admin.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class GenerarSolicitudCompra extends AbstractInternalFrame {
	
	private static final long serialVersionUID = 7004946997014150860L;

	public GenerarSolicitudCompra(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Generar Solicitud de compra");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		
		aceptar.setText("Buscar");
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		validate();
		pack();
	}
}
