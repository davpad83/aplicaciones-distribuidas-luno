package com.adtpo.cpr.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.adtpo.cpr.rmi.ro.IServicios;
import com.adtpo.cpr.rmi.roimpl.ServiciosImpl;

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
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
