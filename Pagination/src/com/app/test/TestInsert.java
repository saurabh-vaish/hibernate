package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtill;

public class TestInsert {


	public static void main(String[] args) {

		Transaction tx=null;

		try(Session ses = HibernateUtill.getSf().openSession())
		{
			tx=ses.beginTransaction();

			// Employee table
			Employee e1 = new Employee();
			e1.setEmpId(1);
			e1.setEmpName("A");
			e1.setEmpSal(2.3);
			
			Employee e2 = new Employee();
			e2.setEmpId(2);
			e2.setEmpName("B");
			e2.setEmpSal(3.3);
			
			
			Employee e3 = new Employee();
			e3.setEmpId(3);
			e3.setEmpName("C");
			e3.setEmpSal(4.3);
			
			
			Employee e4 = new Employee();
			e4.setEmpId(4);
			e4.setEmpName("D");
			e4.setEmpSal(5.3);
			
			Employee e5 = new Employee();
			e5.setEmpId(5);
			e5.setEmpName("E");
			e5.setEmpSal(6.3);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			ses.save(e4);
			ses.save(e5);
			
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
