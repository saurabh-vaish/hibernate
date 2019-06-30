package com.app.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.PanCard;
import com.app.model.Person;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		
		Transaction tx=null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			
			tx=ses.beginTransaction();
			
			// child class
			PanCard p1 = new PanCard(10,"abc","xyz",new Date(1995,11,24),new Date());  // we can also use setters for setting data
			PanCard p2 = new PanCard(11,"mno","pqr",new Date(1993,9,2),new Date());  // we can also use setters for setting data
			
			// parent class

			Person per1 = new Person(101, "P","Hyd",p1);   // p1 is the linking for HAS-A
			Person per2 = new Person(102, "Q","Ban",p2);   // p2 is the linking for HAS-A
			
			ses.save(p1);
			ses.save(p2);
			
			ses.save(per1);
			ses.save(per2);
			
			tx.commit();
			System.out.println(ses.get(Person.class, 101));
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
