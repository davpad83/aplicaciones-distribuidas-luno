package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.cpr.bean.gui.ListasProveedorBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.ov.excepciones.DataEntryException;

public class AgregarRodamiento extends AbstractInternalFrame {

	private static final long serialVersionUID = 8561438507892884729L;
	
	private JLabel lblMarca = new JLabel("Marca"+lblSpace);
	private JTextField marca = new JTextField();

	private JLabel lblCaracteristica = new JLabel("Caracteristica"+lblSpace);
	private JTextField caracteristica = new JTextField();
		
	private JLabel lblOrigen = new JLabel("Origen"+lblSpace);
	private JTextField origen = new JTextField();

	private JLabel lblCantidad = new JLabel("Cantidad"+lblSpace);
	private JTextField cantidad = new JTextField();
	
	private String intro = "Por favor, ingrese los datos del rodamiento y la cantidad" +
			"que desea agregar al stock de la empresa.";
	
	private AbstractTextPane introPane;
	
	public AgregarRodamiento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Agregar Stock Rodamiento");
			
			lblId = new JLabel("Codigo"+lblSpace);
			
			introPane = new AbstractTextPane(intro);
			introPane.constructPane();
			north.add(introPane.scrollPane);

			addField(lblId, id);
			addField(lblMarca, marca);			
			addField(lblOrigen, origen);
			addField(lblCaracteristica, caracteristica);
			addField(lblCantidad, cantidad);
			
			south.add(aceptar);
			south.add(cancelar);
			south.add(restablecerCampos);
			
			aceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						events.agregarStockRodamiento(id.getText(),
								marca.getText(), origen.getText(),
								caracteristica.getText(), Integer
										.parseInt(cantidad.getText()));
						showSuccessMessage();
					} catch (DataEntryException de) {
						showErrorMessage(de.mensaje);
						de.printStackTrace();
					} catch (Exception e1) {
						showErrorMessage();
						e1.printStackTrace();
					}
				}
			});
			
			validate();
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
