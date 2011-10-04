package com.adtpo.admin.gui;

import javax.swing.SwingUtilities;

public class test {
	
	public static void main(String[] arg){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MenuPrincipal mp = new MenuPrincipal();
				
				mp.inicializarGUI("Administrador");
			}
		});
	}
}
