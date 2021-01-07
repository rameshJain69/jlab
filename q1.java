import java.sql.*;
public class qb1 {
public static void main(String args[])
{
String url = "jdbc:mysql://localhost:3306/";
String dbName = "mydb104";
String driver = "com.mysql.jdbc.Driver";
String userName = "root";
String password = "";
Connection conn = null;
try {
Class.forName(driver).newInstance();
conn =DriverManager.getConnection(url+dbName,userName,password);
String query = "Select No_of_Employees FROM Department where Name=CSE";
System.out.println("Connected to the database");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
System.out.println("No of emps in CSE:");
while (rs.next())
{
System.out.println(rs.getString(1));
} //end while
Statement stmt2 = conn.createStatement();
String queryb = "Select Name, Dept_ID FROM Department where Year_Established=2010";
ResultSet rs2 = stmt2.executeQuery(queryb);
System.out.println("Departments established in 2010:");
while (rs2.next())
{
System.out.println(rs2.getString(1));
System.out.println(rs2.getString(2));
}
conn.close();
System.out.println("Disconnected from database");
} //end try
catch(ClassNotFoundException e) {
e.printStackTrace();
}
catch(SQLException e) {
e.printStackTrace();
}
catch (Exception e) {
e.printStackTrace();
}//end catch
}
}
