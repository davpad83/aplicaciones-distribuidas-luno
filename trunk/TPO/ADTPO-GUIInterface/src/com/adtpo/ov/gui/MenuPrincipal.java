package com.adtpo.ov.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class MenuPrincipal extends javax.swing.JFrame {

	private static final long serialVersionUID = -8463050679556798451L;

	//prueba
	JLabel jLabel1 = new JLabel();
	
	private JDesktopPane desktopPane = new DesktopPane();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuRodamientos = new JMenu("Rodamientos");
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuProveedores = new JMenu("Proveedores");
	
	private JMenuItem menuAgregarRodamiento = new JMenuItem("Agregar Stock Rodamiento");
	private JMenuItem menuEliminarRodamiento = new JMenuItem("Eliminar Stock Rodamiento");
	
	private JMenu menuVenta = new JMenu("Venta");
	private JMenuItem menuGenerarSolicitudCompra = new JMenuItem("Cambiar porcentaje de ganancia por defecto");
	
	private JMenuItem menuAgregarCliente = new JMenuItem("Agregar cliente");
	private JMenuItem menuModificarCliente = new JMenuItem("Modificar cliente");
	private JMenuItem menuEliminarCliente = new JMenuItem("Eliminar cliente");
	
	private JMenuItem menuAgregarProveedor = new JMenuItem("Agregar proveedor");
	private JMenuItem menuModificarProveedor = new JMenuItem("Modificar proveedor");
	private JMenuItem menuEliminarProveedor = new JMenuItem("Eliminar proveedor");
	private JMenuItem cargarListaProveedor = new JMenuItem("Cargar nueva lista");
	
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenuItem menuAyudaAcercaDe = new JMenuItem("Acerca de ...");
	
	private JLabel copyRight = new JLabel("Copyright Matias Favale¨ & co.");
	
	private static final int USUARIO_FULLACCESS = 1;
	private static final int USUARIO_ADMINISTRADOR = 2;
	private static final int USUARIO_VENDEDOR = 3;
	
	public MenuPrincipal() {
		super();
		setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Lower screen size;
//		screenSize.height -= 42;
//		screenSize.width -= 42;
		setSize(screenSize);
		setVisible(true);
	}
	
	public void inicializarGUI(String usuario) {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(desktopPane, BorderLayout.CENTER);
			setJMenuBar(menuBar);
			getContentPane().add(BorderLayout.SOUTH, copyRight);
			
			setTitle("Administracion");
			
//			loadBackgroundImage();
			
			menuClientes.add(menuAgregarCliente);
			menuClientes.add(menuModificarCliente);
			menuClientes.add(menuEliminarCliente);
			
			menuProveedores.add(menuAgregarProveedor);
			menuProveedores.add(menuModificarProveedor);
			menuProveedores.add(menuEliminarProveedor);
			menuProveedores.add(cargarListaProveedor);
			
			menuRodamientos.add(menuAgregarRodamiento);
			menuRodamientos.add(menuEliminarRodamiento);
			menuRodamientos.add(menuVenta);
			
			menuVenta.add(menuGenerarSolicitudCompra);
			
			menuAyuda.add(menuAyudaAcercaDe);
			
			//Mapping de usuarios
			int usuarioId = 0;
			if(usuario.equals(LoginManager.userAdmin))
				usuarioId = USUARIO_ADMINISTRADOR;
			else if(usuario.equals(LoginManager.userFullAccess))
				usuarioId = USUARIO_FULLACCESS;
			else if(usuario.equals(LoginManager.userVendedor))
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
			
			cargarListaProveedor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					AgregarListaProveedor alp = new AgregarListaProveedor();
					desktopPane.add(alp);
					alp.validate();
					alp.setVisible(true);
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
					SetPorcentajeDeGanancia gsc = new SetPorcentajeDeGanancia();
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
	
	private void loadBackgroundImage() {
	    ImageIcon icon = new ImageIcon("images/mac_osx.jpg");
	    JLabel l = new JLabel(icon);
	    l.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

	    // Place the image in the lowest possible layer so nothing
	    // can ever be painted under it.
	    desktopPane.add(l, new Integer(Integer.MIN_VALUE));
	  }
	
	class DesktopPane extends JDesktopPane{
		private static final long serialVersionUID = 1L;

		Image bgimage = null;  
	    Dimension dim;  
	    void ContentPanel()  
	    {  
	      bgimage = Toolkit.getDefaultToolkit().createImage("/Users/matiasfavale/Documents/DropBox/LenguajesVisuales2/aplicaciones-distribuidas-luno/TPO/ADTPO-GUIInterface/images/mac_osx.jpeg");  
	      dim = Toolkit.getDefaultToolkit().getScreenSize();  
	      setLayout(null);  
	      setBounds(0,0,dim.width,dim.height);  
	    }  
	  
	    protected void paintComponent(Graphics g)  
	    {  
	      super.paintComponent(g);  
	      g.drawImage(bgimage, 0,0,this.getWidth()-42,this.getHeight()-42,this);  
	    }  
	}
	
}
