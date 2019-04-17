package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class Testget {

	public static void main(String[] args) {

		try(Session ses =HibernateUtil.getSf().openSession())  // try with resources
		{

			// for get() transaction not needed 

			Employee e=ses.get(Employee.class,44);

			System.out.println(e);  



			Employee emp=ses.get(Employee.class,10);

			System.out.println(emp);  // null if no record found then null will come

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}
