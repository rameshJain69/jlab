<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
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
	int price = Integer.parseInt(request.getParameter("price"));
	String auth = (request.getParameter("auth"));
	String pub = (request.getParameter("pub"));
	String title = (request.getParameter("title"));
	int bno = Integer.parseInt(request.getParameter("bno"));

	String url= "jdbc:mysql://localhost:3306/";
	String dbName="virtuoso";
	String driver="com.mysql.jdbc.Driver";
	String userName="root";
	String password="";
	Connection conn =null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Class.forName(driver).newInstance();
		conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
		PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement("insert into book values(?,?,?,?,?)");
		pstmt.setInt(1,bno);
		pstmt.setString(2,title);
		pstmt.setString(3,auth);
		pstmt.setString(4,pub);
		pstmt.setInt(5,price);
		pstmt.execute();
		out.println("Details Entered Successfully");
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<a href="q11form.html">click here for retrieveing details</a>
</body>
</html>
