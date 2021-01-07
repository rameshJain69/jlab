import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
@WebServlet("/Empdeets")
public class Empdeets extends HttpServlet
{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
doGet(request, response);
}
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
 {
 response.setContentType("text/
 PrintWriter out = response.getWriter();
 int id = Integer.parseInt(request.
 String name = request.getParameter("name");
 String add = request.getParameter("add");
 String dob = request.getParameter("dob");
 String url = "jdbc:mysql://localhost:3306/"
String dbName = "mydb104";
String driver = "com.mysql.jdbc.Driver";
String userName = "root";
String password = "";
Connection conn = null;
 try
 {
 Class.forName(driver).newInstance();
 conn = (Connection) DriverManager.getConnection()
 PreparedStatement pstmt = (PreparedStatement)conn.prepareStatement("insert into Employee values(?,?,?,?)");
 pstmt.setInt(2,id);
 pstmt.setString(1, name);
 pstmt.setString(3, add);
 pstmt.setString(4, dob);
 pstmt.execute();
 out.print("Successfully inserted the values");
 Statement st = (Statement) conn.createStatement();
 ResultSet rs = st.executeQuery("select * from Employee");
 out.print("<table> <tr> <th>Name</th> <th>Id</th> <th>Address</th>
<th>DOB</th> </tr>");
 while(rs.next())
 {
 name = rs.getString("employee_name");
 id =rs.getInt("empid");
 add =rs.getString("address");
 dob =rs.getString("date_of_birth")
 out.println("<tr> <th> "+ name +" </th> <th> "+id +" </th><th> "+add+" </th> <th> "+dob+" </th></tr> ");
 }
 out.println("</table>");
 }

 catch(Exception e)
 {
 e.printStackTrace();}
 }
}
