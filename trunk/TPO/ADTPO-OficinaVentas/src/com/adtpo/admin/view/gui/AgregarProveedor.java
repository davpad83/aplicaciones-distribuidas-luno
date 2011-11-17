package com.adtpo.admin.view.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AgregarProveedor extends AbstractInternalFrame{
	
	private static final long serialVersionUID = -3222937216293640414L;

	private JLabel lblNombre = new JLabel("Nombre"+lblSpace);
	private JTextField nombre = new JTextField();
	
	private JLabel lblCalle = new JLabel("Calle"+lblSpace);
	private JTextField calle = new JTextField();
	
	private JLabel lblNumero = new JLabel("Numero"+lblSpace);
	private JTextField numero = new JTextField();
	
	private JLabel lblPiso  = new JLabel("Piso"+lblSpace);
	private JTextField piso = new JTextField();
	
	private JLabel lblDepto = new JLabel("Departamento"+lblSpace);
	private JTextField depto = new JTextField();
	
	private JLabel lblLocalidad = new JLabel("Localidad"+lblSpace);
	private JTextField localidad = new JTextField();
	
	private JLabel lblTipo = new JLabel("Tipo"+lblSpace);
	private JTextField tipo = new JTextField();
	
	private JLabel lblDescuento = new JLabel("Descuento"+lblSpace);
	private JTextField descuento = new JTextField();
	
	private JLabel lblCondiciones = new JLabel("Condiciones"+lblSpace);
	private JTextField condiciones = new JTextField();
	
	private String intro = "Por favor, ingrese los datos del proveedor.";
	
	private AbstractTextPane introPane;
	
	public AgregarProveedor(){
		super();
		initGUI();
	}
	
	public void initGUI(){
		this.setTitle("Agregar Proveedor");
		
		lblId = new JLabel("ID Proveedor"+lblSpace);
		
		introPane = new AbstractTextPane(intro);
		introPane.constructPane();
		north.add(introPane.scrollPane);
		
		addField(lblId, id);		
		addField(lblNombre, nombre);

		addField(lblCalle, calle);
		addField(lblNumero, numero);
		addField(lblPiso, piso);
		addField(lblDepto, depto);
		addField(lblLocalidad, localidad);
		addField(lblTipo,tipo);
		addField(lblDescuento,descuento);
		addField(lblCondiciones,condiciones);
		
		south.add(aceptar);
		south.add(cancelar);
		south.add(restablecerCampos);
		
		validate();
		pack();		
	}
}
