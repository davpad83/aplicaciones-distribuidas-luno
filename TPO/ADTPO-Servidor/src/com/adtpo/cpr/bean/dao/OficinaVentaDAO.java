package com.adtpo.cpr.bean.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.adtpo.cpr.beans.model.Cliente;
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
		try{
			iniciaOperacion();
			almacenaEntidad(cliente);
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
	}

	public Cliente getCliente(Cliente cl) throws DataBaseInvalidDataException{
		Cliente cli =null;
		try{
			iniciaOperacion();
			cli = getEntidad(cl.getIdCliente(), Cliente.class); 
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
		if(cli == null)
			throw new DataBaseInvalidDataException();
		return cli;
	}
	
	public void eliminarCliente(Cliente cl) throws HibernateException{
		try{
			iniciaOperacion();
			sesion.createQuery("delete from Cliente where idCliente = :id").setInteger("id", cl.getIdCliente()).executeUpdate();
		}catch(HibernateException he){
			manejaExcepcion(he);
		}finally{
			terminaOperacion();
		}
			
	}
}
