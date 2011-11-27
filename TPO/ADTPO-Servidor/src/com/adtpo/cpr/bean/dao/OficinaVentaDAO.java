package com.adtpo.cpr.bean.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.adtpo.cpr.beans.model.Cliente;
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

	public Cliente getCliente(Cliente cl) {
		Session session = sf.openSession();
		session.beginTransaction();
		Cliente cliente = (Cliente) session.get(Cliente.class, cl);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return cliente;
	}
	
	public void eliminarCliente(Cliente cl){
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(cl);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

}
