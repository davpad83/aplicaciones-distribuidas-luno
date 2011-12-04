package com.adtpo.cpr.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.adtpo.cpr.beans.model.CasaCentral;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.ro.IConsultas;
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
			IConsultas consultas = (IConsultas) new ConsultasImpl();
			Naming.rebind("//localhost/servicios", serv);
			Naming.rebind("//localhost/consultas", consultas);
			inicializarSistema();
			System.out.print("Servidor rmi corriendo");	
		}catch(RemoteException re){
			re.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void inicializarSistema(){
		CasaCentral.getInstancia().inicializarPorcentajeGanancia();
		CasaCentral.getInstancia().inicializarListasProveedores();
		CasaCentral.getInstancia().actualizarListaRodamientosUnicos();
		CasaCentral.getInstancia().generarListaComparativa();
	}
}
