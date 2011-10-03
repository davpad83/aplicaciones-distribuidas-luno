package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import contador.InterfaceContadora;

public class Cliente {
	private InterfaceContadora contador;
	private int resta=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cliente();
	}
	
	public Cliente(){
		if (conecto()){
			try {
					System.out.println("Probando el sistema...");
					System.out.println("Funcion 1: contar hasta 38");
					contador.contarhastaN(38);
					System.out.println("Funcion 2: Hacer 12154 menos 5482");
					resta= contador.MmenosN(12154, 5482);
					System.out.println("...y el valor retornado fue " + resta);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	private boolean conecto() {
		try {
			contador = (InterfaceContadora) Naming.lookup("//127.0.0.1/ContadorRemoto");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
}
