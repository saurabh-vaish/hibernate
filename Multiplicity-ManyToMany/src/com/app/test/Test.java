package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Client;
import com.app.model.Project;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		
		Transaction tx=null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			
			tx=ses.beginTransaction();
			
			// child class
			
			Project p1 = new Project(589,"p1",900.9);
			Project p2 = new Project(581,"p2",866.7);
			
			// parent class
			
			Client c1 = new Client();
			c1.setClnId(11);
			c1.setClnCode("ABC");
			c1.setLoc("HYD");
			c1.getPobs().add(p1);
			c1.getPobs().add(p2);
			
			Client c2 = new Client();
			c2.setClnId(12);
			c2.setClnCode("XYZ");
			c2.setLoc("BAN");
			c2.getPobs().add(p1);
			c2.getPobs().add(p2);
			
			
			ses.save(p1);
			ses.save(p2);
			ses.save(c1);
			ses.save(c2);
			
			tx.commit();
			System.out.println(ses.get(Client.class, 11));
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
