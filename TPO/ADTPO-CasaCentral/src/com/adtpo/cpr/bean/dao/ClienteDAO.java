package com.adtpo.cpr.bean.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.adtpo.cpr.beans.model.Cliente;
import com.adtpo.cpr.hbt.HibernateUtil;

public class ClienteDAO {
	
	private static ClienteDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static ClienteDAO getInstancia(){
		if(instancia == null){
			HibernateUtil.getSessionFactory();
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDAO();
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
	
}
