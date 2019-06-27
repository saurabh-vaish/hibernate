package com.app.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Employee;

public class Test {

	public static void main(String[] args) {

		
		// creating configuration class object
		Configuration cfg = new Configuration();
		// loading hibernate configuration file
		cfg.configure();
		
		// build session factory object returns SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();

		// creating session object
		Session ses = sf.openSession();

		// begin transaction
		Transaction tx =ses.beginTransaction();

		/* another way
		 * reduced code 
		Session ses = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx =ses.beginTransaction();
		 
		 */
		
		//setting data to employee obj
		Employee e = new Employee();
		e.setEmpId(11);
		e.setEmpName("AB");
		e.setEmpSal(2.4);

		// calling save method ,will insert data
		ses.save(e);

		// commit changes to database
		tx.commit();

		

	}	

}
