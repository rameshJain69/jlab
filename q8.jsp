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
int m1=Integer.parseInt(request.getParameter("m1"));
int m2=Integer.parseInt(request.getParameter("m2"));
int m3=Integer.parseInt(request.getParameter("m3"));
int m4=Integer.parseInt(request.getParameter("m4"));
int m5=Integer.parseInt(request.getParameter("m5"));
int pr=(m1+m2+m3+m4+m5)/5;
if(pr>=90){
	out.println("Your grade is : <h1>S</h1>");
}
else if(pr>=80){
	out.println("Your grade is : <h1>A</h1>");
}
else if(pr>=70){
	out.println("Your grade is : <h1>B</h1>");
}
else if(pr>=60){
	out.println("Your grade is : <h1>C</h1>");
}
else if(pr>=50){
	out.println("Your grade is : <h1>D</h1>");
}
else{
	out.println("Your grade is : <h1>Fail</h1>");
}
%>
</body>
</html>
