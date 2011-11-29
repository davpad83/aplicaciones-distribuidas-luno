package com.adtpo.cpr.bean.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
import com.adtpo.cpr.hbt.HibernateUtil;

public class OficinaVentaDAO {
	
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
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(cliente);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public Cliente getCliente(Cliente cl) throws DataBaseInvalidDataException{
		Session session = sf.openSession();
		session.beginTransaction();
		Cliente cliente = (Cliente) session.get(Cliente.class, cl);
		if(cliente == null)
			throw new DataBaseInvalidDataException();
		session.flush();
		session.getTransaction().commit();
		session.close();
		return cliente;
	}
	
	public void eliminarCliente(Cliente cl) throws HibernateException{
		Session session = sf.openSession();
		session.createQuery("delete from Cliente where idCliente = :id").setInteger("id", cl.getIdCliente()).executeUpdate();
		session.flush();
		session.close();
	}
}
