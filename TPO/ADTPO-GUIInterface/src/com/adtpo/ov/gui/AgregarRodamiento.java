package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.adtpo.ov.excepciones.DataEntryException;

public class AgregarRodamiento extends AbstractInternalFrame {

	private static final long serialVersionUID = 8561438507892884729L;
	
	private JLabel lblMarca = new JLabel("Marca"+lblSpace);
	private JTextField marca = new JTextField();

	private JLabel lblCaracteristica = new JLabel("Caracteristica"+lblSpace);
	private JTextField caracteristica = new JTextField();
		
	private JLabel lblOrigen = new JLabel("Origen"+lblSpace);
	private JTextField origen = new JTextField();

	private JLabel lblPrecioUnitario = new JLabel("Precio Unitario"+lblSpace);
	private JTextField precioUnitario = new JTextField();
	
	private JLabel lblProveedor = new JLabel("Proveedor"+lblSpace);
	private JComboBox proveedor = new JComboBox();
	
	private JLabel lblIdListaProveedor = new JLabel("Lista del Proveedor"+lblSpace);
	private JComboBox idListaProveedor = new JComboBox(); 
	
	private JCheckBox marcaAlternativa = new JCheckBox("Marca Alternativa.");
	
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
			
			HashMap<String, String> nombresProveedores = null;
			try{		
				nombresProveedores = events.getNombresProveedores();
			}catch(Exception e){
				showErrorMessage();
				e.printStackTrace();
			}

			
						
			proveedor.addItem(nombresProveedores);
			proveedor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			addField(lblId, id);
			addField(lblMarca, marca);			
			addField(lblOrigen, origen);
			addField(lblCaracteristica, caracteristica);
			addField(lblPrecioUnitario, precioUnitario);
			addField(lblProveedor, proveedor);
			addField(lblIdListaProveedor, idListaProveedor);
			addField("", marcaAlternativa);
			
			south.add(aceptar);
			south.add(cancelar);
			south.add(restablecerCampos);
			
			aceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						events.agregarRodamiento(Integer.valueOf(id.getText()), marca.getText(), 
								origen.getText(), caracteristica.getText(), precioUnitario.getText()
								, marcaAlternativa.isSelected());
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
