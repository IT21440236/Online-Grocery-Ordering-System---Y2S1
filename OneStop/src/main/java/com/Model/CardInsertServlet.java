package com.Model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CardInsertServlet")
public class CardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		                                          //these parameters are the ones we put in the card.jsp form
		String cardNumber = request.getParameter("cardnumber");
		String expiryDate = request.getParameter("date");
		String cvv = request.getParameter("cvv");
		String name= request.getParameter("name");
		String uPassword = request.getParameter("psw");
		
		
		boolean isTrue;
		
		isTrue = CardDBUtil.insertCARD(cardNumber, expiryDate, cvv, name, uPassword);
		
		if (isTrue == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("successfulcard.jsp");
			//redirect to go to homepage
			//that means the alert box in successful and unsucessful jsp pages should be shown in the home page
			//all css and everything
			dis.forward(request, response);
			
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccessfulcard.jsp");
			dis2.forward(request, response);
		}
		
		
		
			
	}

}
