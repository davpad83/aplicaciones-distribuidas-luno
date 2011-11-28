package com.adtpo.ov.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import org.hibernate.HibernateException;

import com.adtpo.ov.excepciones.DataEntryException;

public class EliminarCliente extends AbstractInternalFrame{

	private static final long serialVersionUID = 6752927912365539767L;
	
	public EliminarCliente(){
		super();
		initGUI();
	}

	public void initGUI(){
		setTitle("Eliminar cliente");
		
		lblId = new JLabel("ID Cliente"+lblSpace);
		
		addField(lblId, id);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					events.eliminarCliente(Integer.parseInt(id.getText()));
					showSuccessMessage();
				} catch (DataEntryException e) {
					showErrorMessage(e.mensaje);
					e.printStackTrace();
				}catch (HibernateException e){
					showErrorMessage(e.getMessage());
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
