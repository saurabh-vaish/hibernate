package com.app.test;

import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Project;
import com.app.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		
		Transaction tx= null;
		
		try(Session ses = HibernateUtil.getSf().openSession())
		{
			tx = ses.beginTransaction();
			
			// make child class object first
			
			Project p = new Project();
			p.setPrjId(112);
			p.setPrjCode("java-121");
			p.setPrjCost(3.4);
			
			// setting data to Collection (Set)
			// here as we make Collection Object in Model class , so don't need to make here .
			// So first getting collection then adding elements 
			
			// setting to list
			Collections.addAll(p.getPrjVersion(), "v1","v2","v3");
			
			// setting to map
			p.getPrjModules().put("REG", "Yes");
			p.getPrjModules().put("LOG", "No");
			p.getPrjModules().put("PAY", "Yes");
			p.getPrjModules().put("EXP", "No");
			
			//inserting data
			ses.save(p);
			
			System.out.println("data saved");
			
			
			tx.commit();
			
		
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	
}
