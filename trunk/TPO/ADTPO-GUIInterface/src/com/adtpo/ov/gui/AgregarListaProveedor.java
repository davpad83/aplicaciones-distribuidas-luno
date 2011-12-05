package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarListaProveedor extends AbstractInternalFrame {
	
	private static final long serialVersionUID = 1203565219522316660L;

	private JFileChooser cargarArchivo = new JFileChooser();
	
	private JLabel lblNombreLista = new JLabel("Nombre de la lista"+lblSpace);
	private JTextField nombreLista = new JTextField();
	
	private JTextField selectedPathFile = new JTextField();
	
	private JButton browse = new JButton("Browse...");
	
	private String intro = "Por favor, ingrese un archivo xml con los datos de la nueva lista de proveedor.";
	
	private AbstractTextPane introPane;
	
	public AgregarListaProveedor(){
		super();
		initGUI();
	}
	
	private void initGUI(){
		this.setTitle("Cargar nueva lista de proveedores");
		
		this.setMinimumSize(getPreferredSize());
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);

		addField("", selectedPathFile);
		center.add(browse);
		
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaCargarArchivo = new JFrame();
				ventanaCargarArchivo.setDefaultCloseOperation(EXIT_ON_CLOSE);
				ventanaCargarArchivo.setTitle("Cargar Archivo XML");
				int returnValue = cargarArchivo.showOpenDialog(ventanaCargarArchivo);
				
				switch(returnValue){
				case JFileChooser.APPROVE_OPTION:
					File archivoSeleccionado = cargarArchivo.getSelectedFile();
					selectedPathFile.setText(archivoSeleccionado.getAbsolutePath());
					try {
						events.agregarListaProveedor(nombreLista.getText(), archivoSeleccionado);
					} catch (Exception e2) {
						showErrorMessage();
						e2.printStackTrace();
					}
					break;
				case JFileChooser.CANCEL_OPTION:
					break;
				case JFileChooser.ERROR_OPTION:
					showErrorMessage("Hubo un error al tratar de levantar el archivo");
					break;
				}
			}
		});
		
		validate();
		pack();
	}
}
