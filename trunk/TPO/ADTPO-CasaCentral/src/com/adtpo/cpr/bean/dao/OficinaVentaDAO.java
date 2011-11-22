package com.adtpo.cpr.bean.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.hbt.HibernateUtil;

public class OficinaVentaDAO {
	
	private static OficinaVentaDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static OficinaVentaDAO getInstancia(){
		if(instancia == null){
			HibernateUtil.getSessionFactory();
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
	
	public void eliminarCliente(Integer id){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(id.toString(), Cliente.class);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	
	
}
