package com.adtpo.ov.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

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
		
		validate();
		pack();		
	}

}
