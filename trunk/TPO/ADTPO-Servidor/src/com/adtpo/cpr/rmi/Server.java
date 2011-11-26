package com.adtpo.cpr.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.adtpo.cpr.ro.IServicios;


public class Server {

	public static void main(String[] args){
		new Server();
	}
	
	public Server(){
		inicializar();
	}
	
	public void inicializar(){
		try{
			LocateRegistry.createRegistry(1099);
			IServicios serv = (IServicios) new ServiciosImpl();
			Naming.rebind("//localhost/servicios", serv);
			System.out.print("Servidor rmi corriendo");	
		}catch(RemoteException re){
			re.getCause().getCause().printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
