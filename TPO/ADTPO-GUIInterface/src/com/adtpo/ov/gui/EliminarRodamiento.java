package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.ov.excepciones.DataEntryException;

public class EliminarRodamiento extends AbstractInternalFrame {
	
	private static final long serialVersionUID = -6046759023520416000L;
	
	private JLabel lblMarca = new JLabel("Marca"+lblSpace);
	private JTextField marca = new JTextField();

	private JLabel lblCaracteristica = new JLabel("Caracteristica"+lblSpace);
	private JTextField caracteristica = new JTextField();
		
	private JLabel lblOrigen = new JLabel("Origen"+lblSpace);
	private JTextField origen = new JTextField();

	private JLabel lblCantidad = new JLabel("Cantidad"+lblSpace);
	private JTextField cantidad = new JTextField();
	
	private String intro = "Por favor, ingrese los datos del rodamiento y la cantidad" +
			"que desea eliminar del stock de la empresa.";
	
	private AbstractTextPane introPane;
	
	public EliminarRodamiento(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Eliminar Stock Rodamiento");
		
		lblId = new JLabel("ID Rodamiento"+lblSpace);
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		addField(lblId, id);
		addField(lblMarca, marca);			
		addField(lblOrigen, origen);
		addField(lblCaracteristica, caracteristica);
		addField(lblCantidad, cantidad);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.eliminarStockRodamiento(id.getText(),
							marca.getText(), origen.getText(),
							caracteristica.getText(), Integer
									.parseInt(cantidad.getText()));
					showSuccessMessage();
				} catch (DataEntryException de) {
					showErrorMessage(de.mensaje);
					de.printStackTrace();
				} catch (Exception e1) {
					showErrorMessage();
					e1.printStackTrace();
				}
			}
		});
		
		validate();
		pack();		
	}

}
