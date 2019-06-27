package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		
		Transaction tx =null;
		
		try(Session ses =HibernateUtil.getSf().openSession())  // try with resources
		{
		 	tx =ses.beginTransaction();
			
			Employee e = new Employee();
			e.setEmpId(54);
			e.setEmpName("srv1");
			e.setEmpSal(15.2);
			
			ses.save(e);  
			
			ses.saveOrUpdate(e); // here it behaves as a save or update i.e. if PK not found in table then save , if found then update
			
			tx.commit();
			
		} catch (Exception e) {
			
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	
}
