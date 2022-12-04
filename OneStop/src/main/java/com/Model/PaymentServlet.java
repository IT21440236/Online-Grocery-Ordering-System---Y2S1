package com.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cardNumber = request.getParameter("cardnumber");
		String cvv = request.getParameter("cvv");
		
		
		try {
			
			List<Payment> payDetails = CustomerPaymentUtil.validate(cardNumber, cvv);
			
			request.setAttribute("payDetails", payDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("paydetails.jsp");
		dis.forward(request, response);
		
		
		
		
		
		
	}
	
	

}
