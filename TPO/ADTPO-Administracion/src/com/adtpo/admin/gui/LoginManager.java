package com.adtpo.admin.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import sun.font.FontManager;

public class LoginManager extends JFrame{
	
	private static final long serialVersionUID = -6056370520374539080L;

	private ArrayList<Login> logins = new ArrayList<Login>();
	
	private String intro = "Para ingresar al sistema debe ingresar usuario y password.";
	
	private AbstractTextPane introPanel;
	
	private JLabel lblUsuario = new JLabel("Usuario: ");
	private JTextField usuario = new JTextField(10);
	
	private JLabel lblPassword = new JLabel("Password: ");
	private JPasswordField password = new JPasswordField(10);
	
	private JButton login = new JButton("Login");
	private JButton cancelar = new JButton("Cancelar");
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				LoginManager inst = new LoginManager();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginManager(){
		GridBagConstraints constraints = new GridBagConstraints();
		getContentPane().setLayout(new BorderLayout());
		setResizable(false);
		setTitle("Autenticaci—n");
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(center, BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.SOUTH);

		//Crear logins
		Login fullAccess = new Login(1, "FullAccess", "fullaccess01");
		Login administrador = new Login(2, "Administrador", "admin01");
		Login vendedor = new Login(3, "Vendedor", "vendedor01");
		
		logins.add(fullAccess);
		logins.add(administrador);
		logins.add(vendedor);
		
		north.setLayout(new BoxLayout(north, BoxLayout.PAGE_AXIS));
		introPanel = new AbstractTextPane(intro);
		introPanel.constructPane();
		
		north.add(introPanel.scrollPane);
		
		center.setLayout(new GridBagLayout());
		constraints.insets = new Insets(3,3,3,3);
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		{
			constraints.gridx = 0;
	        constraints.weightx = 0;
	        constraints.weighty = 0;
	        constraints.anchor = GridBagConstraints.LINE_END;
	        center.add(lblUsuario, constraints);
	        constraints.gridx = 1;
	        constraints.fill = GridBagConstraints.HORIZONTAL;
	        center.add(usuario, constraints);
	        lblUsuario.setLabelFor(usuario);
	        usuario.setToolTipText("Usuarios validos: \nAdministrador/admin01," +
	        		"FullAccess/fullaccess01, Vendedor/vendedor01");
	        constraints.gridy++;
		}
		{
			constraints.gridx = 0;
	        constraints.weightx = 0;
	        constraints.weighty = 0;
	        constraints.anchor = GridBagConstraints.LINE_END;
	        center.add(lblPassword, constraints);
	        constraints.gridx = 1;
	        constraints.fill = GridBagConstraints.HORIZONTAL;
	        center.add(password, constraints);
	        password.setToolTipText("Debe contener al menos 8 caracteres alfanumericos");
	        lblPassword.setLabelFor(password);
	        constraints.gridy++;
		}
		
		south.setLayout(new BoxLayout(south, BoxLayout.LINE_AXIS));
        south.add(Box.createHorizontalGlue()); 
        south.add(Box.createRigidArea(new Dimension(10, 0))); 
        south.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        south.add(login);
        south.add(cancelar);
        
        
        login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Boolean loginInvalido = true;
				for(Login l: logins){
					if(usuario.getText().equals(l.getUsuario()) && password.getText().equals(l.getPassword())
							&& password.getText().length() >= 8){
						MenuPrincipal mp = new MenuPrincipal();
						mp.setLocationRelativeTo(null);
						mp.inicializarGUI(l.getUsuario());
						loginInvalido = false;
					}
				}
				if(loginInvalido){
					JOptionPane.showMessageDialog(new JFrame(), "Usuario o password incorrectos, por favor vuelva a ingresarlos");
					usuario.setText("");
					password.setText("");
				}else{
					dispose();
				}
			}
		});
        
        cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        
        validate();
        pack();
	}
}
