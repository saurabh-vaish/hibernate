package com.app.test;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Ticket;
import com.app.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		
		Transaction tx= null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			tx = ses.beginTransaction();
			
			// make child class object first
		
			Ticket t = new Ticket();
			t.setTicketId(101);
			t.setTicketCost(268.9);
			t.setNoOfPsngrs(2);
			
			// setting data to Collection (Set)
			// here as we make Collection Object in Model class , so don't need to make here .
			// So first getting collection then adding elements 
			t.getSeatNums().add("12");
			t.getSeatNums().add("13");
			t.getSeatNums().add("14");
			
			// or we can use this way also
			Collections.addAll(t.getNames(), "ram","shyam","ajay");  // (collection,elements to add);
			
			
			//inserting data
			ses.save(t);
			
			System.out.println("data saved");

			tx.commit();
			
			Ticket t1 =ses.get(Ticket.class,101);
			System.out.println(t1);
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	
}
