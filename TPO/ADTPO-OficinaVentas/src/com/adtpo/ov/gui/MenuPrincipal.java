package com.adtpo.ov.gui;

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

public class MenuPrincipal extends javax.swing.JFrame {

	private static final long serialVersionUID = -8463050679556798451L;

	private JDesktopPane desktopPane = new JDesktopPane();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuRodamientos = new JMenu("Rodamientos");
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuProveedores = new JMenu("Proveedores");
	
	private JMenuItem menuAgregarRodamiento = new JMenuItem("Agregar Rodamiento");
	private JMenuItem menuEliminarRodamiento = new JMenuItem("Eliminar Rodamiento");
	
	private JMenu menuVenta = new JMenu("Venta");
	private JMenuItem menuGenerarSolicitudCompra = new JMenuItem("Cambiar porcentaje de ganancia por defecto");
	
	private JMenuItem menuAgregarCliente = new JMenuItem("Agregar cliente");
	private JMenuItem menuModificarCliente = new JMenuItem("Modificar cliente");
	private JMenuItem menuEliminarCliente = new JMenuItem("Eliminar cliente");
	
	private JMenuItem menuAgregarProveedor = new JMenuItem("Agregar proveedor");
	private JMenuItem menuModificarProveedor = new JMenuItem("Modificar proveedor");
	private JMenuItem menuEliminarProveedor = new JMenuItem("Eliminar proveedor");
	
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem menuAyudaAcercaDe = new JMenuItem("Acerca de ...");
	
	private JLabel copyRight = new JLabel("Copyright Matias Favale ¨");
	
	private static final int USUARIO_FULLACCESS = 1;
	private static final int USUARIO_ADMINISTRADOR = 2;
	private static final int USUARIO_VENDEDOR = 3;
	
	public MenuPrincipal() {
		super();
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(800, 600);
	}
	
	public void inicializarGUI(String usuario) {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(desktopPane, BorderLayout.CENTER);
			setJMenuBar(menuBar);
			getContentPane().add(BorderLayout.SOUTH, copyRight);
			
			setTitle("Administracion");
			
			menuClientes.add(menuAgregarCliente);
			menuClientes.add(menuModificarCliente);
			menuClientes.add(menuEliminarCliente);
			
			menuProveedores.add(menuAgregarProveedor);
			menuProveedores.add(menuModificarProveedor);
			menuProveedores.add(menuEliminarProveedor);
			
			menuRodamientos.add(menuAgregarRodamiento);
			menuRodamientos.add(menuEliminarRodamiento);
			menuRodamientos.add(menuVenta);
			
			menuVenta.add(menuGenerarSolicitudCompra);
			
			menuAyuda.add(menuAyudaAcercaDe);
			
			//Mapping de usuarios
			int usuarioId = 0;
			if(usuario.equals("Administrador"))
				usuarioId = USUARIO_ADMINISTRADOR;
			else if(usuario.equals("FullAccess"))
				usuarioId = USUARIO_FULLACCESS;
			else if(usuario.equals("Vendedor"))
				usuarioId = USUARIO_VENDEDOR;
			
			switch(usuarioId){
			case USUARIO_FULLACCESS:
				menuBar.add(menuClientes);
				menuBar.add(menuProveedores);
				menuBar.add(menuRodamientos);
				break;
			case USUARIO_ADMINISTRADOR:
				menuBar.add(menuProveedores);
				menuBar.add(menuRodamientos);
				break;
			case USUARIO_VENDEDOR:
				menuBar.add(menuClientes);
				break;
			}
						
			menuBar.add(menuAyuda);

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
					final ModificarCliente mc = new ModificarCliente();
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
			
			menuAgregarProveedor.addActionListener(new ActionListener() {
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
			
			menuEliminarRodamiento.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					EliminarRodamiento er = new EliminarRodamiento();
					desktopPane.add(er);
					er.validate();
					er.setVisible(true);
				}
			});
			
			menuGenerarSolicitudCompra.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PorcentajeDeGanancia gsc = new PorcentajeDeGanancia();
					desktopPane.add(gsc);
					gsc.validate();
					gsc.setVisible(true);
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
