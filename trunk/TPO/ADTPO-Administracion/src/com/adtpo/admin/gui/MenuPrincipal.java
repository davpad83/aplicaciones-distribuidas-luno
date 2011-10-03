package com.adtpo.admin.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class MenuPrincipal extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8463050679556798451L;

	private JDesktopPane desktopPane = new JDesktopPane();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuRodamientos = new JMenu("Rodamientos");
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuProveedores = new JMenu("Proveedores");
	
	private JMenuItem menuAgregarRodamiento = new JMenuItem("Agregar Rodamiento");
	private JMenuItem menuEliminarRodamiento = new JMenuItem("Eliminar Rodamiento");
	
	private JMenuItem menuAgregarCliente = new JMenuItem("Agregar cliente");
	private JMenuItem menuModificarCliente = new JMenuItem("Modificar cliente");
	private JMenuItem menuEliminarCliente = new JMenuItem("Eliminar cliente");
	
	private JMenuItem menuAgregarProdeedor = new JMenuItem("Agregar proveedor");
	private JMenuItem menuModificarProveedor = new JMenuItem("Modificar proveedor");
	private JMenuItem menuEliminarProveedor = new JMenuItem("Eliminar proveedor");
	
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem menuAyudaAcercaDe = new JMenuItem("Acerca de ...");
	
	private JLabel copyRight = new JLabel("Copyright Matias Favale ¨");
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal inst = new MenuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setSize(800, 600);
			}
		});
	}
	
	public MenuPrincipal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(desktopPane, BorderLayout.CENTER);
			setJMenuBar(menuBar);
			getContentPane().add(BorderLayout.SOUTH, copyRight);
			
			setTitle("Administracion");
			
			menuBar.add(menuClientes);
			menuBar.add(menuProveedores);
			menuBar.add(menuRodamientos);
			
			menuBar.add(menuAyuda);
			
			menuClientes.add(menuAgregarCliente);
			menuClientes.add(menuModificarCliente);
			menuClientes.add(menuEliminarCliente);
			
			menuProveedores.add(menuAgregarProdeedor);
			menuProveedores.add(menuModificarProveedor);
			menuProveedores.add(menuEliminarProveedor);
			
			menuRodamientos.add(menuAgregarRodamiento);
			menuRodamientos.add(menuEliminarRodamiento);
			
			menuAyuda.add(menuAyudaAcercaDe);

			desktopPane.setSize(400,300);
			desktopPane.setBackground(Color.LIGHT_GRAY);
			desktopPane.validate();
			desktopPane.setVisible(true);
			
			validate();
		
			
			menuAgregarCliente.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					AgregarCliente ac = new AgregarCliente();
					desktopPane.add(ac);
					ac.validate();
					ac.setVisible(true);
				}
			});
			
			menuModificarCliente.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ModificarCliente mc = new ModificarCliente();
					desktopPane.add(mc);
					mc.validate();
					mc.setVisible(true);
				}
			});
			
			menuEliminarCliente.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					EliminarCliente ec = new EliminarCliente();
					desktopPane.add(ec);
					ec.validate();
					ec.setVisible(true);
				}
			});
			
			menuAgregarProdeedor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AgregarProveedor ap = new AgregarProveedor();
					desktopPane.add(ap);
					ap.validate();
					ap.setVisible(true);
				}
			});
			
			menuModificarProveedor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ModificarProveedor mp = new ModificarProveedor();
					desktopPane.add(mp);
					mp.validate();
					mp.setVisible(true);
				}
			});
			
			menuEliminarProveedor.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					EliminarProveedor ep = new EliminarProveedor();
					desktopPane.add(ep);
					ep.validate();
					ep.setVisible(true);
				}
			});
			
			menuAgregarRodamiento.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					AgregarRodamiento ar = new AgregarRodamiento();
					desktopPane.add(ar);
					ar.validate();
					ar.setVisible(true);
				}
			});
			
			menuAyudaAcercaDe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String title = "Acerca de este sistema";
					String message = "Sistema de administracion de cotizacion de rodamientos\n Version 1.0 no comerciable.";
					JOptionPane.showInternalMessageDialog(desktopPane, message, title, JOptionPane.INFORMATION_MESSAGE);
				}
			});
			
			setSize(800, 600);
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
