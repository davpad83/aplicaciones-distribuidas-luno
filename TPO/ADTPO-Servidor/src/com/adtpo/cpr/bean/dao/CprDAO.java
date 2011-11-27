package com.adtpo.cpr.bean.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.hbt.HibernateUtil;

public class CprDAO {

	private static CprDAO instancia = null;
	private static SessionFactory sf = null;

	public static CprDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new CprDAO();
		}
		return instancia;
	}

	public void grabarProveedor(Proveedor proveedor) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(proveedor);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public Proveedor getProveedor(Proveedor prove) {
		Session session = sf.openSession();
		session.beginTransaction();
		Proveedor p = (Proveedor) session.get(Proveedor.class, prove);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return p;
	}

	public void eliminarProveedor(Proveedor proveedor) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.delete(proveedor);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getNombresProveedores() {
		Session session = sf.openSession();
		List<Object[]> nombres = session.getNamedQuery("NombresProve").list();
		session.close();
		return nombres;
	}

}
