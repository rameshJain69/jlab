import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
public class QB2 {
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
conn = DriverManager.getConnection(url+dbName,userName,password);
String query = "Select * FROM stud where CGPA<9";
System.out.println("Connected to the database");
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
System.out.println("Students with CGPA<9:");
while (rs.next())
{
System.out.println(rs.getString(1)+' '+rs.getFloat(2)+' '+rs.getInt(3)+' '+rs.getString(4));
} //end while
String queryb = "UPDATE stud SET CGPA=9.4 WHERE name='JOHN'";
Statement stmt2 = conn.createStatement();
int c = stmt2.executeUpdate(queryb);
System.out.println(c + " rows updated");
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
