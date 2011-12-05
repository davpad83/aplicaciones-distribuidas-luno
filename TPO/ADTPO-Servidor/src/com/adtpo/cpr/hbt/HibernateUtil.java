package com.adtpo.cpr.hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.adtpo.cpr.beans.model.*;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(Cliente.class);
             config.addAnnotatedClass(CondicionVenta.class);
             config.addAnnotatedClass(Proveedor.class);
             config.addAnnotatedClass(PorcentajeGanancia.class);
             config.addAnnotatedClass(Rodamiento.class);
             config.addAnnotatedClass(OficinaVentas.class);
             config.addAnnotatedClass(MovimientosStock.class);
             config.addAnnotatedClass(StockRodamiento.class);
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}
