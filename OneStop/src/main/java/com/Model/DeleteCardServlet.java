package com.Model;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCardServlet")
public class DeleteCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("pass");
		boolean isTrue;
		
		isTrue = CardDBUtil.deleteCard(password);
		
		if (isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("cardinsert.jsp");
			dis.forward(request, response);		
		} else {
			
			List<Card> cardDetails = CardDBUtil.getCardDetails(password);
			request.setAttribute("cardDetails", cardDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("carddetail.jsp");
			dis.forward(request, response);
		}
		
		
		
		
	}

}
