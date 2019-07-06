package com.app.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.app.model.Employee;
import com.app.util.HibernateUtill;

public class TestSelectWithWhere {


	public static void main(String[] args) {

		try(Session ses = HibernateUtill.getSf().openSession())
		{
			String hql = " select e.empId,e.empName,p.prjCode "
						+ " from "+Employee.class.getName() +" as e "
						+" left outer join "
						+ " e.prjs as p "
						//+ " where p.prjCost<:cost ";  // using named parameter
						+ " where p IS NULL"; //=?Left join-inner join output
			
			Query q = ses.createQuery(hql);
			//q.setParameter("cost", 15.0);
			List<Object[]> list= q.list();
			
			for(Object[] o : list)
			{
				System.out.println(o[0]+" "+o[1]+" "+o[2]);
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("done");
	}

}
