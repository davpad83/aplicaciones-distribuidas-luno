package uade.ejercicio.clase5.servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import uade.ejercicio.clase5.controlador.AdministracionImpl;
import uade.ejercicio.clase5.controlador.AsociacionesImpl;
import uade.ejercicio.clase5.controlador.ConsultasImpl;
import uade.ejercicio.clase5.interfaces.IAdministracion;
import uade.ejercicio.clase5.interfaces.IAsociaciones;
import uade.ejercicio.clase5.interfaces.IConsultas;

public class Server {
    
	
	public static void main(String[] args)
	{
		new Server();
	}
	
	public Server() {
		iniciar();
	}
	
    public void iniciar() {
    	try {
    		LocateRegistry.createRegistry(1099);	
    		IAdministracion admin = new AdministracionImpl();
    		IConsultas consultas = new ConsultasImpl();
    		IAsociaciones asociaciones = new AsociacionesImpl();
    		
            Naming.rebind ("//localhost/admin", admin);
            Naming.rebind("//localhost/consultas", consultas);
            Naming.rebind("//localhost/asociaciones", asociaciones);
            
            System.out.println("Servidor en linea.");
            
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
