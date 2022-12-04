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


@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String cardnumber = request.getParameter("cardnumber");
		String password = request.getParameter("pass");
		
		//New code for js validation//
		boolean isTrue;
		
		
		                    //calling the validate method we defined in CardDBUtil.java
		isTrue = CardDBUtil.validate(cardnumber, password);
		
		
		//if users card num and password is correct , user should be directed to the card details page
		if (isTrue == true) {
			List<Card> cardDetails = CardDBUtil.getCardDetails(password);
			request.setAttribute("cardDetails", cardDetails);
			
			RequestDispatcher  dis = request.getRequestDispatcher("carddetail.jsp");
			
			//to get forwarded to the pg we use the below one, just pass the two parameters as it is.
			dis.forward(request, response);
			
		} else {
			
			//out.println is used to show the alert within the web browser
			out.println("<script type='text/javascript'>");//start of js
			out.println("alert('Your username or password is incorrect');");
			out.println("location='card.jsp'");//if incorrect go to card.jsp page
			out.println("</script>");//end of js

		}
		
		//END OF NEW CODE
		
		/*
		try {
			//creating a list object
			List<Card> cardDetails = CardDBUtil.validate(cardnumber, password);
			
			//to set the details we've taken from above we use the following method
			//1st parameter is the name of the attribute, we can give any name
			//2nd parameter is the object
		    //basically what this does is when re-directing to the next pg and tell wht to send.
			
			request.setAttribute("cardDetails", cardDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//We use the requestdispatcher class to tell to which pg to nagivate
		//useraccount.jsp is the page we want to go to, its related to the VIEW, so it will be created inside the WebContent folder
	
		RequestDispatcher  dis = request.getRequestDispatcher("carddetail.jsp");
		
		//to get forwarded to the pg we use the below one, jsut pass the two parameters as it is.
		dis.forward(request, response);
		
		*/
		
		
	}

}
