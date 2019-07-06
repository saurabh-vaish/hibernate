package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Employee;
import com.app.model.Project;
import com.app.util.HibernateUtill;

public class TestInsert {


	public static void main(String[] args) {

		Transaction tx=null;

		try(Session ses = HibernateUtill.getSf().openSession())
		{
			tx=ses.beginTransaction();

			// project table
			Project p1 = new Project();
			p1.setProjId(101);
			p1.setPrjCode("P1");
			p1.setPrjCost(12.3);
			
			Project p2 = new Project();
			p2.setProjId(102);
			p2.setPrjCode("P2");
			p2.setPrjCost(13.3);
			
			Project p3 = new Project();
			p3.setProjId(103);
			p3.setPrjCode("P3");
			p3.setPrjCost(14.3);
			
			Project p4 = new Project();
			p4.setProjId(104);
			p4.setPrjCode("P4");
			p4.setPrjCost(15.3);
			
			Project p5 = new Project();
			p5.setProjId(105);
			p5.setPrjCode("P5");
			p5.setPrjCost(16.3);
			
			
			// Employee table
			Employee e1 = new Employee();
			e1.setEmpId(1);
			e1.setEmpName("A");
			e1.setEmpSal(2.3);
			e1.getPrjs().add(p3);
			
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
			e4.getPrjs().add(p2);
			
			Employee e5 = new Employee();
			e5.setEmpId(5);
			e5.setEmpName("E");
			e5.setEmpSal(6.3);
			e5.getPrjs().add(p1);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			ses.save(e4);
			ses.save(e5);

			ses.save(p1);
			ses.save(p2);
			ses.save(p3);
			ses.save(p4);
			ses.save(p5);

			
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		}

	}

}
