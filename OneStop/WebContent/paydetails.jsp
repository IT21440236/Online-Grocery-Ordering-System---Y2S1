<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>paydetails</title>
</head>
<body>

	<c:forEach var="pay" items="${payDetails}">
	
	
		 <table>
	 	<tr>
	 		<td>Card Number</td>
	 		<td>${pay.cardNumber}</td>	
	 	</tr>
	 
	 	<tr>
	 		<td>Card Name</td>
	 		<td>${pay.cardName}</td>	
	 	</tr>
	 	
	 	<tr>
	 		<td>Card Type</td>
	 		<td>${pay.cardType}</td>	
	 	</tr>
	 	
	 	<tr>
	 		<td>Expiry Date</td>
	 		<td>${pay.expiryDate}</td>	
	 	</tr>
	 	
	 	<tr>
	 		<td>CVV</td>
	 		<td>${pay.cvv}</td>	
	 	</tr>
	 	
	 	<tr>
	 		<td>amount</td>
	 		<td>${pay.amount}</td>	
	 	</tr> 
	 </table>
	
	
	
	
	
	
	
	
	
	</c:forEach>


</body>
</html>