package HibernateDAO;

import hbt.HibernateUtil;
import org.hibernate.SessionFactory;

public class HibernateSession {
	
	private static HibernateSession instancia = null;
	@SuppressWarnings("unused")
	private static SessionFactory sf = null;

	public static HibernateSession getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new HibernateSession();
		} 
		return instancia;
	}
}
