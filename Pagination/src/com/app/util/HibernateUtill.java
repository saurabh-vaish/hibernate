package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {

	public static SessionFactory sf;
	
	static {
		Configuration cfg= new Configuration();
		sf=cfg.configure().buildSessionFactory();
	}
	public static SessionFactory getSf()
	{
		return sf;
	}
	
}
