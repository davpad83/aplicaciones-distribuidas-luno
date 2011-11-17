package com.adtpo.admin.view.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class EliminarRodamiento extends AbstractInternalFrame {
	
	private static final long serialVersionUID = -6046759023520416000L;
	
	private JLabel lblMarca = new JLabel("Marca"+lblSpace);
	private JTextField marca = new JTextField();
	
	public EliminarRodamiento(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Eliminar Rodamiento");
		
		lblId = new JLabel("ID Rodamiento"+lblSpace);
		
		addField(lblId, id);
		addField(lblMarca, marca);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();		
	}

}
