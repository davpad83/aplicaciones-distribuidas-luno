package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.ov.excepciones.DataEntryException;

public class EliminarProveedor extends AbstractInternalFrame{

	private static final long serialVersionUID = 1561047648206960604L;

	private JLabel lblCuit = new JLabel("Cuit:"+lblSpace);
	private JTextField cuit = new JTextField();
	
	private String intro = "Ingrese el id o el Cuit del proveedor que desea eliminar.\n " +
			"Nota: Completar ambos campos es invalido.";
	
	private AbstractTextPane introPane;
	
	public EliminarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		setTitle("Eliminar Proveedor");
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		addField(lblId, id);
		addField(lblCuit, cuit);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.eliminarProveedor(Integer.valueOf(id.getText()), cuit.getText());
					showSuccessMessage();
					closeInternalFrame();
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
