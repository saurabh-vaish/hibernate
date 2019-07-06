package com.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.IEmployeeDao;
import com.app.dao.Impl.EmployeeDaoImpl;
import com.app.model.Employee;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//1. getting form parameter
		
		String id=req.getParameter("empId");
		String empName=req.getParameter("empName");
		String sal=req.getParameter("empSal");
		String empDept=req.getParameter("empDept");
	
		//2 . parsing values
		int empId= Integer.parseInt(id);
		double empSal= Double.parseDouble(sal);
	
		// 3. constructing obj of model class
		Employee e = new Employee();
		
		// 4. setting values
		e.setEmpId(empId);
		e.setEmpName(empName);
		e.setEmpSal(empSal);
		e.setEmpDept(empDept);
		
		//5. making IEmployeeDao object using its implementation class 
		IEmployeeDao dao = new EmployeeDaoImpl();
		
		//6. calling saveEmployee from IEmployeeDao
		Integer eid = dao.saveEmployee(e);
		
		//7.crete message and setAttribute
		
		String msg="Employee registered with id '"+id+"' successfully ";
		
		req.setAttribute("msg", msg);
		
		//8sending value to UI
		req.getRequestDispatcher("Register.jsp")
		.forward(req, res);
		
	}

}
