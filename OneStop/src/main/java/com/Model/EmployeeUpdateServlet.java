package com.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid = request.getParameter("empid");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("passw");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.updateemployee(eid, username, email, phone, password);
		
		if(isTrue = true)
		{
			List<Employee> empDetails = EmployeeDBUtil.getEmployeeDetails(eid);
			request.setAttribute("empDetails", empDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("employeeaccount.jsp");
			dis.forward(request, response);
		}
		else
		{
			List<Employee> empDetails = EmployeeDBUtil.getEmployeeDetails(eid);
			request.setAttribute("empDetails", empDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("employeeaccount.jsp");
			dis.forward(request, response);
		}
		
	}

}
