package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// since SessionFactory is heavy object so we are using this class so that this obj can be load only one time 
	
	// SessionFactory will load driver , create connection and prepare statements  
	
	
	private static SessionFactory sf=null;
	
	static {
		sf =new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSf()
	{
		return sf;
	}
	
}
