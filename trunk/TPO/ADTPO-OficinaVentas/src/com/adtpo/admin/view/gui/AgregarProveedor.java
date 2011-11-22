package com.adtpo.admin.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarProveedor extends AbstractInternalFrame{
	
	private static final long serialVersionUID = -3222937216293640414L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblDescuento = new JLabel("Descuento"+lblSpace);
	private JTextField descuento = new JTextField();
	
	private JLabel lblCondiciones = new JLabel("Condiciones"+lblSpace);
	private JTextField condiciones = new JTextField();
	
	private String intro = "Por favor, ingrese los datos del proveedor.";
	
	private AbstractTextPane introPane;
	
	public AgregarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Agregar Proveedor");

		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		addField(lblDescuento,descuento);
		addField(lblCondiciones,condiciones);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				events.agregarProveedor(nombre.getText(), new Float(Float.parseFloat(descuento.getText())));
			}
		});		
		validate();
		pack();		
	}
}
