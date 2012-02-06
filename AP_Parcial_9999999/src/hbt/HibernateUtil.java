package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Clubes;
import entities.Faltas;
import entities.Goles;
import entities.GolesId;
import entities.Jugadores;
import entities.Partidos;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(Jugadores.class);
             config.addAnnotatedClass(Partidos.class);
             config.addAnnotatedClass(Goles.class);
             config.addAnnotatedClass(Faltas.class);
             config.addAnnotatedClass(Clubes.class);
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
