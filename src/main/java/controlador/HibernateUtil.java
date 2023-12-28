package controlador;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFatory = builSessionFactory();
	
	public static SessionFactory builSessionFactory() {
		
		try {
		return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().
				configure().build());
			
		
		} catch (Throwable ex) {
			System.err.println(ex);
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFatory;
	}

}
