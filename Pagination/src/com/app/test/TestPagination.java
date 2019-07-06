package com.app.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.app.model.Employee;
import com.app.util.HibernateUtill;

public class TestPagination {

	
	/**
	 * 
	 * tr = total rows,   ps = page size (rows to be displayed )
	 * np = no of pages to be shown       , pn= current page number 
	 * 
	 * 
	 * 	np = tr/ts + (tr % ts ?0 1:0) ;
	 * 
	 * **/
	
	

	public static void main(String[] args) {

		try(Session ses = HibernateUtill.getSf().openSession())
		{
			String hql = " from com.app.model.Employee ";
			
			// pagination 
			
			int pn=2; int ps=4;
			
			Query q = ses.createQuery(hql);
			
			// pagination method
			q.setFirstResult((pn-1)*ps);
			q.setMaxResults(ps);
			
			List<Employee> list= q.list();
			
			list.forEach(System.out::println);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("done");
	}

}
