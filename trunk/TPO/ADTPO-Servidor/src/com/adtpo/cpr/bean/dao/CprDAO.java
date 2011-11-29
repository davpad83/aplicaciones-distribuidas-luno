package com.adtpo.cpr.bean.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.adtpo.cpr.beans.model.PorcentajeGanancia;
import com.adtpo.cpr.beans.model.Proveedor;
import com.adtpo.cpr.excepciones.DataBaseInvalidDataException;
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

	public void grabarProveedor(Proveedor proveedor) throws HibernateException{
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(proveedor);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public Proveedor getProveedor(Proveedor prove) throws DataBaseInvalidDataException {
		Session session = sf.openSession();
		session.beginTransaction();
		Proveedor p = (Proveedor) session.get(Proveedor.class, prove);
		if(p == null)
			throw new DataBaseInvalidDataException();
		session.flush();
		session.getTransaction().commit();
		session.close();
		return p;
	}

	public void eliminarProveedor(Proveedor proveedor) throws HibernateException{
		Session session = sf.openSession();
		if(proveedor.getIdProveedor()>0)
			session.createQuery("delete from Proveedor where idProveedor = " +
					":id").setInteger("id", proveedor.getIdProveedor()).executeUpdate();
		else if(!proveedor.getCuit().isEmpty())
				session.createQuery("delete from Proveedor where cuit = " +
				":cuit").setString("cuit", proveedor.getCuit()).executeUpdate();
		session.flush();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getNombresProveedores() throws HibernateException{
		Session session = sf.openSession();
		List<Object[]> nombres = session.getNamedQuery("NombresProve").list();
		session.close();
		return nombres;
	}

	public void setPorcentajeGanancia(float porcentaje) {
		Session session = sf.openSession();
		session.u
		session.createQuery("Update Table Politicas where discriminator = " +
				":dis").setString("dis", "PG").executeUpdate();
		session.flush();
		session.close();
	}

	public void inicializarPorcentajeGanancia(PorcentajeGanancia pg){
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(pg);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public float getPorcentajeGanancia() {
		Session session = sf.openSession();
		session.createQuery("from Politicas where discriminator = " +
				":dis").setString("dis", "PG").executeUpdate();
		return 0;
	}

}
