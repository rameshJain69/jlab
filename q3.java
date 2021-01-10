import java.sql.*;
import java.util.*;
public class q3 
{

	public static void main(String args[]) throws InstantiationException, IllegalAccessException
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "1MS18CS021";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "";
		Connection conn = null;
		try
		{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName, user, pass);
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the amount");
			int amt=s.nextInt();
			System.out.println("Enter the Id");
			int id=s.nextInt();
			
			conn.setAutoCommit(false);
			Statement s1 = conn.createStatement();
			String q = "select * from acc";
			ResultSet r1;
			r1 = s1.executeQuery(q);
			System.out.println("initial");
			while(r1.next())
			{
				String f1 = r1.getString(1);
				String f2 = r1.getString(2);
				System.out.println(f1+" "+f2);
			}
			
			PreparedStatement p1 = conn.prepareStatement("Update acc set bal=? where id = ?");
			p1.setInt(1, amt);
			p1.setInt(2, id);
			
			//Statement st = conn.createStatement();
			Savepoint sv1 = conn.setSavepoint();
			p1.execute();
			r1= s1.executeQuery(q);
			System.out.println("After update");
			while(r1.next())
			{
				String f1 = r1.getString(1);
				String f2 = r1.getString(2);
				System.out.println(f1+" "+f2);
			}
			conn.rollback(sv1);
			System.out.println("After roll back");
			r1 = s1.executeQuery(q);
			while(r1.next())
			{
				String f1 = r1.getString(1);
				String f2 = r1.getString(2);
				System.out.println(f1+" "+f2);
			}
			conn.setAutoCommit(true);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(SQLException e)
		{
			
		}
	}
}
