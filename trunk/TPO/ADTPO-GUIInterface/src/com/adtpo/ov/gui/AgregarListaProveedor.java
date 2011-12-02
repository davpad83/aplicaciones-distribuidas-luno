package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarListaProveedor extends AbstractInternalFrame {
	
	private static final long serialVersionUID = 1203565219522316660L;

	private JFileChooser cargarArchivo = new JFileChooser();
	
	private JLabel lblNombreLista = new JLabel("Nombre de la lista"+lblSpace);
	private JTextField nombreLista = new JTextField();
	
	private String intro = "Por favor, ingrese un archivo xml con los datos de la nueva lista de proveedor.";
	
	private AbstractTextPane introPane;
	
	public AgregarListaProveedor(){
		super();
		initGUI();
	}
	
	private void initGUI(){
		this.setTitle("Cargar nueva lista de proveedores");
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		cargarArchivo.getSelectedFile();
		cargarArchivo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		center.add(cargarArchivo);
		
		validate();
		pack();
	}
}
