package com.Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PaymentInsertServlet")
public class PaymentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cardNumber = request.getParameter("cardnumber");
		String cardName = request.getParameter("name");
		String cardType = request.getParameter("type");
		String expiryDate = request.getParameter("date");
		String cvv = request.getParameter("cvv");
		String amount = request.getParameter("amount");
		
		
		boolean isTrue;
		
		isTrue = CustomerPaymentUtil.insertpayment(cardNumber, cardName, cardType, expiryDate, cvv, amount);
		
		if (isTrue == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
			//redirect to go to homepage
			//that means the alert box in successful and unsucessful jsp pages should be shown in the home page
			//all css and everything
			dis.forward(request, response);
			
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("paymentinsert.jsp");
			dis2.forward(request, response);
		}
	}

}
