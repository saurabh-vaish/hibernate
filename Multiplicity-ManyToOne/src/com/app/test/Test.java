package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Admin;
import com.app.model.Department;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		
		Transaction tx=null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			
			tx=ses.beginTransaction();
			
			
			// child class
			Admin a1 = new Admin(106,"ab","active");  // we can also use setters for setting data
			Admin a2 = new Admin(107,"xy","none");  // we can also use setters for setting data
			
			// parent class

			Department d1 = new Department();
			d1.setDeptId(6);
			d1.setDeptCode("Dev");
			d1.setAdmin(a1);

			Department d2 = new Department();
			d2.setDeptId(7);
			d2.setDeptCode("QA");
			d2.setAdmin(a1);
			
			Department d3 = new Department();
			d3.setDeptId(8);
			d3.setDeptCode("Prod");
			d3.setAdmin(a2);
			
			Department d4 = new Department();
			d4.setDeptId(9);
			d4.setDeptCode("Ms");
			d4.setAdmin(a2);
			
			Department d5 = new Department();
			d5.setDeptId(5);
			d5.setDeptCode("Hra");
			d5.setAdmin(a2);
			
			
			ses.save(a1);
			ses.save(a2);
			
			ses.save(d1);
			ses.save(d2);
			ses.save(d3);
			ses.save(d4);
			ses.save(d5);
			
			tx.commit();
			
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
