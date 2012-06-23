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
             config.addAnnotatedClass(Proveedor.class);
             config.addAnnotatedClass(CondicionVenta.class);
             config.addAnnotatedClass(Cliente.class);
             config.addAnnotatedClass(StockRodamiento.class);
             config.addAnnotatedClass(PorcentajeGanancia.class);
             config.addAnnotatedClass(Politicas.class);
             config.addAnnotatedClass(ListasProveedor.class);
             config.addAnnotatedClass(Rodamiento.class);
             config.addAnnotatedClass(OficinaVentas.class);
             config.addAnnotatedClass(ItemRodamiento.class);
             config.addAnnotatedClass(ItemListaComparativa.class);
             config.addAnnotatedClass(MapaRodamientoPrecio.class);
             config.addAnnotatedClass(MovimientosStock.class);
             config.addAnnotatedClass(Cotizacion.class);
             config.addAnnotatedClass(Venta.class);
             config.addAnnotatedClass(Factura.class);
             config.addAnnotatedClass(OrdenDeCompra.class);
             config.addAnnotatedClass(ListaComparativa.class);
             config.addAnnotatedClass(PolPagoContado.class);
             config.addAnnotatedClass(PolPagoCortoPlazo.class);
             config.addAnnotatedClass(PolVolumenVenta.class);
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
