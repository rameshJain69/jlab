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
	String name = request.getParameter("name");
	out.println("Good afternoon "+name+"<br>");
	int age = Integer.parseInt(request.getParameter("age"));
	if(age>63){
		out.println("The price for Movie: $50");
	}
	else if(age<10){
		out.println("The price for Movie: $20");
	}
	else{
		out.println("The price for Movie: $80");	
	}
%>

</body>
</html>
