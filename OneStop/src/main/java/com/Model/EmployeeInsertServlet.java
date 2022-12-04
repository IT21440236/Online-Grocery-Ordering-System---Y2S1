package com.Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeInsertServlet")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("pswd");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.insertemployee(username, email, phone, password);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("employeelogin.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("employeeinsert.jsp");
			dis2.forward(request, response);
		}
		
	}

}
