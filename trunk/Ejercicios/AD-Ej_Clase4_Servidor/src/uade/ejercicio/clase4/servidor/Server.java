package uade.ejercicio.clase4.servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import uade.ejercicio.clase4.controlador.AdministracionImpl;
import uade.ejercicio.clase4.interfaces.IAdministracion;

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
            Naming.rebind ("//localhost/admin", admin);
            System.out.println("Servidor en linea en: //localhost/admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
