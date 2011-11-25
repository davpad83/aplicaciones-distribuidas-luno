package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.ov.excepciones.DataEntryException;

public class CondicionVenta extends AbstractInternalFrame {
	
	private static final long serialVersionUID = -8541010162293236007L;

	private JLabel lblInteres = new JLabel("Interes"+lblSpace);
	private JTextField interes = new JTextField();
	
	private JLabel lblTipo = new JLabel("Tipo"+lblSpace);
	private JTextField tipo = new JTextField();
	
	private String intro = "Por favor, ingrese los datos de la condicion de venta.";
	
	private AbstractTextPane introPane;
	
	public CondicionVenta(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		
		this.setTitle("Agregar Condicion de Venta");
		
		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		addField(lblInteres, interes);
		addField(lblTipo, tipo);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.nuevaCondicionVenta(Float.valueOf(interes.getText()), tipo.getText());
				} catch (DataEntryException de) {
					showErrorMessage(de.mensaje);
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
