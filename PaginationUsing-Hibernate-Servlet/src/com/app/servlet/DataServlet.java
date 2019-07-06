package com.app.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.IEmployeeDao;
import com.app.dao.Impl.EmployeeDaoImpl;
import com.app.model.Employee;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
	    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		IEmployeeDao dao = new EmployeeDaoImpl();
		
		/***  pagination details  ****/
		
		int tr = (int) dao.getRowCount();  // total rows
		int ps = 4 ;  // page size
		int np = tr/ps + (tr%ps>0?1:0);
		
		int pn =1; // current page
		
		// read data from user 
		
		String pns = req.getParameter("pn");
		
		if(pns!=null&& !pns.equals(""))
		{
			pn = Integer.parseInt(pns);
		}
		
		List<Employee> emps = dao.getAllEmps(pn, ps);
		
		req.setAttribute("list", emps);
		req.setAttribute("nps", np);
		
		// forward to Data.jsp
		req.getRequestDispatcher("Data.jsp").forward(req, res);
		
	}

}
