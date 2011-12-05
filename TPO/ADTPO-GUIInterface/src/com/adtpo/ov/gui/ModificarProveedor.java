package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.adtpo.cpr.bean.gui.ClienteBean;
import com.adtpo.cpr.bean.gui.ProveedorBean;
import com.adtpo.ov.excepciones.DataEntryException;

public class ModificarProveedor extends AbstractInternalFrame{

	private static final long serialVersionUID = -5917208785922770760L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblCuit = new JLabel("Cuit"+lblSpace);
	private JTextField cuit = new JTextField();
	
	private ProveedorBean proveedorBuscado = null;
		
	public ModificarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		setTitle("Modificar Proveedor");

		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		addField(lblId, id);
		center.add(buscar);
		center.add(new JSeparator());
		
		addField(lblNombre, nombre);
		addField(lblCuit, cuit);

		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		
		buscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					proveedorBuscado = events.getProveedor(Integer.parseInt(id.getText()));
					nombre.setText(proveedorBuscado.getNombre());
					cuit.setText(proveedorBuscado.getCuit());
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
					events.modificarProveedor(Integer.parseInt(id.getText()), nombre.getText());
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

