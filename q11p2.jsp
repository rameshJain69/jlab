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
	//int price = Integer.parseInt(request.getParameter("price"));
	//String auth = (request.getParameter("auth"));
	//String pub = (request.getParameter("pub"));
	String title = (request.getParameter("title"));
	//int bno = Integer.parseInt(request.getParameter("bno"));

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
		Statement st = (Statement)conn.createStatement();
		String query = "SELECT * FROM book WHERE title =" +"'"+title+"'";
		ResultSet rs=st.executeQuery(query);
		out.println("<table><tr><th>Bool_no.</th><th>Title</th><th>Author</th><th>Publicaition</th><th>Price</th>");
		
		while(rs.next()){
			int b_no=rs.getInt("bno");
			String t = rs.getString("title");
			String a =rs.getString("auther");
			String pu =rs.getString("publisher");
			int pr =rs.getInt("price");
			out.print("<strong><tr><td>"+b_no+"</td><td>"+t+"</td><td>"+a+"</td><td>"+pu+"</td><td>"+pr+"</td></tr></strong>");
		}
		out.println("</table>");
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
<h1>Have a Gret Day!!</h1>
</body>
</html>
