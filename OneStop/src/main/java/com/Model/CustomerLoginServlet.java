package com.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("eid");
		String password = request.getParameter("pass");
		
		try {
		List<Customer> cusDetails = CustomerDBUtil.validate(email, password);
		request.setAttribute("cusDetails", cusDetails);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
		dis.forward(request, response); 
		
/*		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("eid");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.validate(email, password);
		
		if(isTrue==true)
		{
			List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(email);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		else
		{
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your email or password is incorrect');");
			out.println("location='customerlogin.jsp'");
			out.println("</script>");
		} */
		
	}

}
