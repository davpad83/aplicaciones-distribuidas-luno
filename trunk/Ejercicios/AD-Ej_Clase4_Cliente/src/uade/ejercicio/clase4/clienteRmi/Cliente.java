package uade.ejercicio.clase4.clienteRmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.omg.CORBA.Principal;

import uade.ejercicio.clase4.interfaces.IAdministracion;

public class Cliente {

	private IAdministracion admin;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cliente();
	}
	public Cliente(){
		new Principal();
	}
	
	private boolean conecto(){
		try {
			admin= (IAdministracion) Naming.lookup("//127.0.0.1/admin");
			return true;
		} catch (MalformedURLException e) {
			// lugar incorrecto o mal escrito
			e.printStackTrace();
		} catch (RemoteException e) {
			// error en el metodo o accion que quiero invocar
			e.printStackTrace();
		} catch (NotBoundException e) {
			// si no encuentra la clase para hacer el cast
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
