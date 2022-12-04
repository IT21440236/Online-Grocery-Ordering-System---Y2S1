package com.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateCardServlet")
public class UpdateCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cardNumber = request.getParameter("cardnumber");
		String expiryDate = request.getParameter("date");
		String cvv = request.getParameter("cvv");
		String cardholderName = request.getParameter("name");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = CardDBUtil.updatecard(cardNumber, expiryDate, cvv, cardholderName, password);
		
		
		
		if (isTrue == true) {
			
			List<Card> cardDetails = CardDBUtil.getCardDetails(password);
			request.setAttribute("cardDetails", cardDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("carddetail.jsp");
			dis.forward(request, response);		
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccessfulupdate.jsp");
			dis2.forward(request, response);
		}
	}

}
