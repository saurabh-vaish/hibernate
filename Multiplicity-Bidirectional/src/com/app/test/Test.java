package com.app.test;

import java.util.Arrays;

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
			Admin a1 = new Admin();  // we can also use setters for setting data
			  a1.setAdminId(106); 
			  a1.setAdminName("ab");
			  a1.setServiceType("active");
			 
			
			Admin a2 = new Admin();  // we can also use setters for setting data
			a2.setAdminId(107); 
			a2.setAdminName("xy");
			a2.setServiceType("none");
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
			
			
			/// setting departments in admin
			
			a1.setDeps(Arrays.asList(d1,d4));

			a2.setDeps(Arrays.asList(d2,d3,d5));
			
			
			ses.save(a1);
			ses.save(a2);
			
			ses.save(d1);
			ses.save(d2);
			ses.save(d3);
			ses.save(d4);
			ses.save(d5);
			
			tx.commit();
			
			System.out.println(ses.get(Admin.class,106));
			
			//Admin [adminId=106, adminName=ab, serviceType=active, deps=[Department [deptId=6, deptCode=Dev, admin=], Department [deptId=7, deptCode=QA, admin=]]]

		}
		catch (Exception e) {
		//	tx.rollback();
			e.printStackTrace();
		}
		
	}

}
