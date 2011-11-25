package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.ov.excepciones.DataEntryException;

public class EliminarRodamiento extends AbstractInternalFrame {
	
	private static final long serialVersionUID = -6046759023520416000L;
	
	public EliminarRodamiento(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Eliminar Rodamiento");
		
		lblId = new JLabel("ID Rodamiento"+lblSpace);
		
		addField(lblId, id);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.eliminarRodamiento(Integer.valueOf(id.getText()));
					showSuccessMessage();
				} catch (DataEntryException e) {
					showErrorMessage(e.mensaje);
					e.printStackTrace();
				} catch (Exception e) {
					showErrorMessage();
					e.printStackTrace();
				}
			}
		});
		
		validate();
		pack();		
	}

}
