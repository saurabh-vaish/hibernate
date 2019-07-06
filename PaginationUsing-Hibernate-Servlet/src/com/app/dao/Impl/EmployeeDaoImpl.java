package com.app.dao.Impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public Integer saveEmployee(Employee e) {

		Transaction tx=null;

		try(Session ses = HibernateUtil.getSf().openSession())
		{
			tx=ses.beginTransaction();

			ses.save(e);

			tx.commit();

		}catch (Exception e2) {
			tx.rollback();
			e2.printStackTrace();
		}

		return e.getEmpId();
	}

	@Override
	public long getRowCount() {

		String hql = "select count(empId) from "+Employee.class.getName();

		long count=0;

		try(Session ses = HibernateUtil.getSf().openSession())
		{

			Query q =ses.createQuery(hql);

			count = (long) q.uniqueResult();

		}catch (Exception e2) {
			e2.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Employee> getAllEmps(int pn, int ps) {

		String hql = " from "+Employee.class.getName();

		List<Employee> emps=null;

		try(Session ses = HibernateUtil.getSf().openSession())
		{

			Query q =ses.createQuery(hql);

			q.setFirstResult((pn-1)*ps); // getting first element
			q.setMaxResults(ps);

			emps= q.list();			

		}catch (Exception e2) {
			e2.printStackTrace();
		}

		return emps;
	}

}
