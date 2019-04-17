package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class TestUpdate {

	public static void main(String[] args) {

		Transaction tx =null;

		try(Session ses =HibernateUtil.getSf().openSession())  // try with resources
		{
			tx =ses.beginTransaction();

			Employee e = new Employee();
			e.setEmpId(64);
			e.setEmpName("jana");
			e.setEmpSal(15.2);

			ses.update(e);

			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();
		}

	}


}

