package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		
		Transaction tx= null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			tx = ses.beginTransaction();
			
			// make child class object first
			
			Address a = new Address();
			a.setHno("M-291");
			a.setLoc("HYD");
			
			// parent class object 
			Employee e = new Employee();
			e.setEmpId(10);
			e.setEmpName("swetara");
			e.setAddr(a);
			
			
			//inserting data 
			ses.save(e);
			
			System.out.println("data saved");
			
			
			tx.commit();
			
			// fetching data 
			Employee emp = ses.get(Employee.class, 10);   //get does not need transaction
			
			System.out.println(emp);
			
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	
}
