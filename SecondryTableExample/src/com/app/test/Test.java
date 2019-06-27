package com.app.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Product;
import com.app.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		Transaction tx= null;


		try(Session ses = HibernateUtil.getSf().openSession())
		{

			tx = ses.beginTransaction();

			Product p = new Product();
			p.setProdId(15);
			p.setProdCode("XZ");
			p.setProdCost("100");
			p.setProdSlab("5.5");
			p.setGstSlab("18");
			p.setMrp(200.0);
			p.setDisc(2.3);
			p.setTotal(210.4);


			ses.save(p);

			System.out.println("done");

			tx.commit();
			
			  Product prod = ses.get(Product.class, 15); // doesn't need transaction
			  System.out.println(prod);
			 

		}catch (Exception e) {

			tx.rollback();
			e.printStackTrace();
		}
	}

}
