package com.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid = request.getParameter("empid");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.deleteEmployee(eid);
		
		if(isTrue==true)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeinsert.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			List<Employee> empDetails = EmployeeDBUtil.getEmployeeDetails(eid);
			request.setAttribute("empDetails", empDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeaccount.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}
