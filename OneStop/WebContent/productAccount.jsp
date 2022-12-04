<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="pro" items="${proDetails}">

	<c:set var="ID" value="${pro.id}"/>
	<c:set var="Name" value="${pro.name}"/>
	<c:set var="Company" value="${pro.company}"/>
	<c:set var="Price" value="${pro.price}"/>

${pro.id}
${pro.name}
${pro.company}
${pro.price}
</c:forEach>
	
	<c:url value="UpdateProduct.jsp" var="proUpdate">
		<c:param name="id" value="${ID}"/>
		<c:param name="name" value="${Name}"/>
		<c:param name="company" value="${Company}"/>
		<c:param name="price" value="${Price}"/>
		
	</c:url>
	
	<a href="${proUpdate}"> 
	<input type="button" name="update" value="Update my product">
	</a>

</body>
</html>