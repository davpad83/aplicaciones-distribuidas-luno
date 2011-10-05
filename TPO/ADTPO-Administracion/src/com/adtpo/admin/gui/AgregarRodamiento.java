package com.adtpo.admin.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarRodamiento extends AbstractInternalFrame {

	private static final long serialVersionUID = 8561438507892884729L;
	
	private JLabel lblCaracteristica = new JLabel("Caracteristica"+lblSpace);
	private JTextField caracteristica = new JTextField();
	
	private JLabel lblMarca = new JLabel("Marca"+lblSpace);
	private JTextField marca = new JTextField();
	
	private JLabel lblOrigen = new JLabel("Origen"+lblSpace);
	private JTextField origen = new JTextField();
	
	private JLabel lblPtoReposicion = new JLabel("Punto de reposicion"+lblSpace);
	private JTextField puntoReposicion = new JTextField();
	
	private JLabel lblPtoReabastecimiento = new JLabel("Punto de reabastecimiento"+lblSpace);
	private JTextField ptoReabastecimiento = new JTextField();
	
	private JLabel lblStockInicial = new JLabel("Stock inicial"+lblSpace);
	private JTextField stockInicial = new JTextField();
	
	private String intro = "Por favor, ingrese los datos del rodamiento.";
	
	private AbstractTextPane introPane;
	
	public AgregarRodamiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Agregar Rodamiento");
			
			lblId = new JLabel("Codigo"+lblSpace);
			
			introPane = new AbstractTextPane(intro);
			introPane.constructPane();
			north.add(introPane.scrollPane);
			
			addField(lblId, id);
			addField(lblCaracteristica, caracteristica);
			addField(lblMarca, marca);			
			addField(lblOrigen, origen);
			addField(lblPtoReabastecimiento, ptoReabastecimiento);
			addField(lblPtoReposicion, puntoReposicion);
			addField(lblStockInicial, stockInicial);

			south.add(aceptar);
			south.add(cancelar);
			south.add(restablecerCampos);
			
			validate();
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
