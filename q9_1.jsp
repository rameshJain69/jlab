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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession Session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		response.sendRedirect("q9_2.jsp");
		
		
	%>
</body>
</html>
