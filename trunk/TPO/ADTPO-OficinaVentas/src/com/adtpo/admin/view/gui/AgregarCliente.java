
package com.adtpo.admin.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarCliente extends AbstractInternalFrame {
	
	private static final long serialVersionUID = 6209070033046936202L;
	
	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblApellido = new JLabel("Apellido"+lblSpace);
	private JTextField apellido = new JTextField();
	
	private JLabel lblTelefono = new JLabel("Telefono"+lblSpace);
	private JTextField telefono = new JTextField();
	
	private JLabel lblEmail = new JLabel("Email"+lblSpace);
	private JTextField email = new JTextField();

	private String intro = "Por favor, ingrese los datos del cliente.";
	
	private AbstractTextPane introPane;
	
	public AgregarCliente(){
		super();
		initGUI();
	}

	public void initGUI(){
		
		this.setTitle("Agregar Cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		addField(lblId,id);		
		addField(lblNombre, nombre);
		addField(lblApellido, apellido);
		addField(lblTelefono, telefono);
		addField(lblEmail, email);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				events.agregarCliente(nombre.getText(), apellido.getText(), telefono.getText(), email.getText());
			}
		});
		validate();
		pack();
	}
}
