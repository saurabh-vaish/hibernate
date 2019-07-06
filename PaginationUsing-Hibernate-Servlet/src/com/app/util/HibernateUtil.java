package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf=null;
	
	static {
		
		sf=new Configuration().configure().buildSessionFactory();
		
	}
	
	public static SessionFactory getSf()
	{
		return sf;
	}
	
}
