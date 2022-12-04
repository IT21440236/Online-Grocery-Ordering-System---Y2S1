<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String company=request.getParameter("company");
		String price=request.getParameter("price");
	%>
<form action="Update" method="post">
	ProductID <input type="text" name="pid" value="<%=id%>" readonly><br>
	ProductName <input type="text" name="pname" value="<%=name%>"><br>
	Company <input type="text" name="com" value="<%=company%>"><br>
	Price <input type="text" name="pprice" value="<%=price%>"><br>
	
	<input type="submit" name="submit" value="Update Product"><br>
</form>

</body>
</html>