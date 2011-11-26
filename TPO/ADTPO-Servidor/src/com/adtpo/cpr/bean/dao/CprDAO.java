package com.adtpo.cpr.bean.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adtpo.cpr.hbt.HibernateUtil;

public class CprDAO {
	
	private static CprDAO instancia = null;
	private static SessionFactory sf = null;
	
	public static CprDAO getInstancia(){
		if(instancia == null){
			HibernateUtil.getSessionFactory();
			sf = HibernateUtil.getSessionFactory();
			instancia = new CprDAO();
		} 
		return instancia;
	}
	
	public void getNombresProveedores(){
		Session session = sf.openSession();
		
		
	}

}
