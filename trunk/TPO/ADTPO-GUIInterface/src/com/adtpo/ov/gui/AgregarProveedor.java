package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.ov.excepciones.DataEntryException;

public class AgregarProveedor extends AbstractInternalFrame{
	
	private static final long serialVersionUID = -3222937216293640414L;

	private JLabel lblCuit = new JLabel("Cuit"+lblSpace);
	private JTextField cuit = new JTextField();

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
		
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
		
		addField(lblCuit,cuit);
		addField(lblNombre, nombre);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.agregarProveedor(cuit.getText(), nombre.getText());
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
