package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class TestDelete {

	
public static void main(String[] args) {
		
		Transaction tx =null;
		
		try(Session ses =HibernateUtil.getSf().openSession())  // try with resources
		{
		 	tx =ses.beginTransaction();
			
			Employee e = new Employee();
			e.setEmpId(54);
			
			ses.delete(e);
			
			tx.commit();
			
		} catch (Exception e) {
			
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	
}
