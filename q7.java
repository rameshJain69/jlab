import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Q5Update")
public class Q5Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Q5Update() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			Connection conn = null;
			PrintWriter out = response.getWriter();
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "Q5";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root"; 
			String password = "";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database");
	
			//to print all the existing entries look here
			Statement st = (Statement) conn.createStatement();
			ResultSet rs=st.executeQuery("select * from Subjects");
			while(rs.next())
 			{
 			int fid=rs.getInt("fid");
 			String sub=rs.getString("sname");
 			int sid = rs.getInt("sid");
 			out.println("FacID "+fid+" SubName "+sname+" SubID "+sid);
 			out.println("<br>");
			 }
		
			//update	
			int fidask = Integer.parseInt(request.getParameter("fidask"));
			String snameask = request.getParameter("snameask");
			
			System.out.println(snameask);
			PreparedStatement ps1 = conn.prepareStatement("UPDATE faculty set sname = (?) where fid = (?)");
			ps1.setString(1,snameask);
			ps1.setInt(2, fidask);
			
			int cnt = ps1.executeUpdate();
			
			out.println("<p>Updated "+ cnt + "rows</p>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
