package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class TestLoad {

	public static void main(String[] args) {

		try(Session ses =HibernateUtil.getSf().openSession())  // try with resources
		{

			// for get() transaction not needed 

			Employee e=ses.load(Employee.class,44);

			System.out.println(e);  

			Employee emp=ses.load(Employee.class,10);

			System.out.println(emp);  // ObjectNotFoundException if no record found then exception will come

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}
