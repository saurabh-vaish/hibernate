package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.EmpId;
import com.app.model.Employee;
import com.app.util.HibernateUtill;

public class TestInsert {


	public static void main(String[] args) {

		Transaction tx=null;

		try(Session ses = HibernateUtill.getSf().openSession())
		{
			tx=ses.beginTransaction();

			// we can also use this way for storing data
			
			EmpId e = new EmpId();
			e.setEmpId(10);
			e.setDeptId(101);
			
			Employee emp = new Employee();
			emp.setEid(e);
			emp.setEmpName("ABC");
			emp.setDeptName("CPTR");
			
			ses.save(emp);

			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
