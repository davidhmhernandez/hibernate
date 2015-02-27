package utis;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class Conector {
	private static final SessionFactory sessionFactory;
	
	 static  {
	    sessionFactory = new Configuration().configure().buildSessionFactory();
	}	

	
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}


}
