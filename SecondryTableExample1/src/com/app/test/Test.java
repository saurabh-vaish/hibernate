package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Transaction tx= null;
		
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
		
			tx = ses.beginTransaction();
			
			Employee e = new Employee();
			e.setEmpId(11);
			e.setEmpName("ajay");
			e.setEmpRole("Admin");
			e.setEmpDept("Dev");
			e.setEmpPrj("java");
			e.setEmpExp("3.4");
			
			ses.save(e);
			
			System.out.println("done");
			
			tx.commit();
			
			Employee emp = ses.get(Employee.class, 11);   // doesn't need transaction
			System.out.println(emp);
			
			
		}catch (Exception e) {
		
			tx.rollback();
			e.printStackTrace();
		}
	}
	
}
