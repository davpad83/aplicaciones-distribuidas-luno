package com.adtpo.admin.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class PorcentajeDeGanancia extends AbstractInternalFrame {
	
	private static final long serialVersionUID = 7004946997014150860L;
	
	private static final String intro = "Ingrese el porcentaje de ganancia que se utilizar�" +
	" por defecto al momento de calcular el precio de venta de un rodamiento. " +
	"\nNota: Recuerde que este porcentaje variara luego del primer a�o de comercializaci�n de cada rodamiento" +
	" dependiendo de las ventas de dicho rodamiento.";
	
	private JLabel lblPorcentaje = new JLabel("Porcentaje"+lblSpace);
	private JTextField porcentaje = new JTextField(4);
	
	private AbstractTextPane introPanel;
	
	public PorcentajeDeGanancia(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Cambiar porcentaje de Ganancia por defecto");
		
		introPanel = new AbstractTextPane(intro);
		introPanel.setMaximumCharactersBeforeEnter(60);
		introPanel.constructPane();
		
		north.add(introPanel.scrollPane);
		
		addField(lblPorcentaje, porcentaje);
		
		south.add(aceptar);
		south.add(cancelar);

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		validate();
		pack();
	}
}
