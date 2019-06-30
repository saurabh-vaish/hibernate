package com.app.test;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Person;
import com.app.model.Vehicle;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		
		Transaction tx=null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			
			tx=ses.beginTransaction();
			
			// child class
			
			Vehicle v1 = new Vehicle(101, "JKL89", "HYD");
			Vehicle v2 = new Vehicle(102, "QRT49", "SYD");
			Vehicle v3 = new Vehicle(103, "AC85", "UP");
			Vehicle v4 = new Vehicle(104, "MNO87", "BI");
			Vehicle v5 = new Vehicle(105, "POR29", "TL");   // not attaching with any parent so Orphan Row/Object
			
			
			// parent class

			Person p1 = new Person();
			p1.setPerosnId(11);
			p1.setPerName("ABC");
			p1.setPerAddr("HYD");
			p1.getVobs().add(v1);
			p1.getVobs().add(v4);
			
			Person p2 = new Person();   // p2 is the linking for HAS-A
			p2.setPerosnId(12);
			p2.setPerName("XYZ");
			p2.setPerAddr("BAN");
			
			Collections.addAll(p2.getVobs(), v2,v3);
			
			/*
			 * ses.save(v1); ses.save(v2); ses.save(v3); ses.save(v4); ses.save(v5);
			 * 
			 * ses.save(p1); ses.save(p2);
			 */ 
			tx.commit();
			System.out.println(ses.get(Person.class, 11));
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
