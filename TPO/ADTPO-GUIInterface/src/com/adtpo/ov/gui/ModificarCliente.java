package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.ov.excepciones.DataEntryException;

public class ModificarCliente extends AbstractInternalFrame{

	private static final long serialVersionUID = -4553475305493550346L;
	
	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblApellido = new JLabel("Apellido"+lblSpace);
	private JTextField apellido = new JTextField();
	
	private JLabel lblTelefono = new JLabel("Telefono"+lblSpace);
	private JTextField telefono = new JTextField();
	
	private JLabel lblEmail = new JLabel("Email"+lblSpace);
	private JTextField email = new JTextField();
	
	private ClienteBean clienteBuscado = null;
	
	public ModificarCliente(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Modificar Cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		center.add(buscar);
		center.add(new JSeparator());
		addField(lblNombre, nombre);
		addField(lblApellido, apellido);
		addField(lblTelefono, telefono);
		addField(lblEmail, email);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);

		
		buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					clienteBuscado = events.getCliente(Integer.parseInt(id.getText()));
					nombre.setText(clienteBuscado.getNombre());
					apellido.setText(clienteBuscado.getApellido());
					telefono.setText(clienteBuscado.getTelefono());
					email.setText(clienteBuscado.getEmail());
				} catch (DataEntryException de) {
					showErrorMessage(de.mensaje);
					de.printStackTrace();
				} catch (Exception e) {
					showErrorMessage();
					e.printStackTrace();
				}
			}
		});
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.modificarCliente(Integer.parseInt(id.getText()), nombre.getText(), 
							apellido.getText(), telefono.getText(), email.getText());
				}  catch (DataEntryException de) {
					showErrorMessage(de.mensaje);
					de.printStackTrace();
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
