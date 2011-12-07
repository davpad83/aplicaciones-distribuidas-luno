package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AgregarListaProveedor extends AbstractInternalFrame {
	
	private static final long serialVersionUID = 1203565219522316660L;

	private JFileChooser cargarArchivo = new JFileChooser();
	
	private JLabel lblNombreLista = new JLabel("Nombre de la lista"+lblSpace);
	private JTextField nombreLista = new JTextField();
	
	private JTextField selectedPathFile = new JTextField();
	
	private JButton browse = new JButton("Browse...");
	
	private String intro = "Por favor, ingrese un archivo xml con los datos de la nueva lista de proveedor.";
	
	private AbstractTextPane introPane;
	
	private File archivoSeleccionado;
	
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
		addField("", aceptar);
		center.add(browse);
		
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				FileFilter filter = new FileNameExtensionFilter("xml", "xml");
				cargarArchivo.addChoosableFileFilter(filter);
				int ret = cargarArchivo.showDialog(null, "Open file");
				if (ret == JFileChooser.APPROVE_OPTION) {
					archivoSeleccionado = cargarArchivo.getSelectedFile();
					selectedPathFile.setText(archivoSeleccionado.getName());
				}
			}
		});
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					events.agregarListaProveedor(nombreLista.getText(), archivoSeleccionado);
				} catch (Exception e2) {
					showErrorMessage();
					e2.printStackTrace();
				}
			}
		});
		validate();
		pack();
	}
}
