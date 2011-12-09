package com.adtpo.cpr.bean.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.beans.model.Factura;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.hbt.HibernateUtil;

public class OficinaVentaDAO extends AbstractDAO{
	
	private static OficinaVentaDAO instancia = null;
	private static SessionFactory sf = null;
	
	public OficinaVentaDAO(){
		//empty
	}
	
	public static OficinaVentaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new OficinaVentaDAO();
		} 
		return instancia;
	}
	
	public void grabarCliente(Cliente cliente){
		almacenaEntidad(cliente);
	}

	public Cliente getCliente(Cliente cl) throws DataBaseInvalidDataException{
		return getEntidad(cl.getIdCliente(), Cliente.class); 
	}
	
	public Cliente getCliente(int idCliente) throws DataBaseInvalidDataException{
		return getEntidad(idCliente, Cliente.class); 
	}
	
	public Cliente getClientePorId(int idCliente) throws DataBaseInvalidDataException{
		return getEntidad(idCliente, Cliente.class); 
	}
	
	public void eliminarCliente(Cliente cl) throws HibernateException{
		removerEntidad(cl);
	}

	public ArrayList<Factura> getFacturas() {
		return (ArrayList<Factura>) getListaEntidades(Factura.class);
	}
}
