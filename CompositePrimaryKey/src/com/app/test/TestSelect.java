package com.app.test;

import org.hibernate.Session;

import com.app.model.EmpId;
import com.app.model.Employee;
import com.app.util.HibernateUtill;

public class TestSelect {


	public static void main(String[] args) {

		try(Session ses = HibernateUtill.getSf().openSession())
		{
			// for fetching data in composite key case 
			// first provide data to key class 
			// then pass object to get()
			
			EmpId eid = new EmpId(10,101);
			
			Employee e=ses.get(Employee.class , eid);
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
