package com.adtpo.admin.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import sun.security.util.Password;

public class LoginManager extends JFrame{
	
	private static final long serialVersionUID = -6056370520374539080L;

	private ArrayList<PasswordAuthentication> logins = new ArrayList<PasswordAuthentication>();
	
	private JLabel lblIntro = new JLabel("Ingrese usuario y password.");
	
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
		setTitle("Login");
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(center, BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.SOUTH);

		//Crear logins
		PasswordAuthentication fullAccess = new PasswordAuthentication("FullAccess", ("fullaccess01").toCharArray());
		PasswordAuthentication administrador = new PasswordAuthentication("Administrador", ("admin01").toCharArray());
		PasswordAuthentication vendedor = new PasswordAuthentication("Vendedor", ("vendedor01").toCharArray());
		logins.add(fullAccess);
		logins.add(administrador);
		logins.add(vendedor);
		
		north.add(lblIntro);
		
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(PasswordAuthentication l: logins){
					
					System.out.println(usuario.getText()+"/"+password.getPassword());
					System.out.println(l.getUserName()+"/"+l.getPassword());
					
					if(usuario.getText().equals(l.getUserName()) & password.getPassword().toString() == String.valueOf(l.getPassword())){
						MenuPrincipal mp = new MenuPrincipal();
						mp.inicializarGUI(l.getUserName());
						dispose();
					}
				}
				JOptionPane.showMessageDialog(new JFrame(), "Usuario o password incorrectos, por favor vuelva a intentarlo luego");
				dispose();
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
