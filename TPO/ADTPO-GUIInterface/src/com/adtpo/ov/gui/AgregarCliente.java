
package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.adtpo.ov.events.EventHandler;
import com.adtpo.ov.excepciones.DataEntryException;

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
	
	private JLabel lblIdCondicionVenta = new JLabel("Condicion"+lblSpace);
	private JTextField idCondicion = new JTextField();

	private ArrayList<Integer> idsCondicion = new ArrayList<Integer>();
	
	private JButton agregarCondicion = new JButton("Agregar");
	
	private String intro = "Por favor, ingrese los datos del cliente.";
	
	private AbstractTextPane introPane;
	
	public AgregarCliente(){
		super();
		initGUI();
	}

	public void initGUI(){
		
		this.setTitle("Agregar Cliente");
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		addField(lblNombre, nombre);
		addField(lblApellido, apellido);
		addField(lblTelefono, telefono);
		addField(lblEmail, email);
		addField(lblIdCondicionVenta, idCondicion);
		addField("", agregarCondicion);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		agregarCondicion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer id = Integer.valueOf(idCondicion.getText());
				if (!idsCondicion.contains(id)) {
					idsCondicion.add(id);
					JOptionPane.showMessageDialog(new JFrame(),
							"Condicion de Venta agregada!");
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
							"Este cliente ya tiene esta condicion de venta.");
				}
			}
		});
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventHandler eh;
				try {
					eh = new EventHandler();
					eh.agregarCliente(nombre.getText(), apellido.getText(), telefono.getText(),
							email.getText(), idsCondicion);				
					showSuccessMessage();
					closeInternalFrame();
				} catch (DataEntryException de) {
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
