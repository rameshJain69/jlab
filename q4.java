import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Police")
public class Police extends HttpServlet {

    public Police() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter out = res.getWriter();
			String url = "jdbc:mysql://localhost:3306/"; 
		    String dbName = "police"; 
		    String driver = "com.mysql.jdbc.Driver"; 
		    String user = "root";  
		    String password = ""; 
		    
		  //=====================================================
			res.setContentType("text/html");
			String area = req.getParameter("area");
			out.println(area);
		    
			Statement pstmt;
		    try { 
		        Class.forName(driver).newInstance(); 
		        Connection conn = DriverManager.getConnection(url+dbName, user, password); 
		        //     PreparedStatement pstmt; 
		        String sql = "SELECT phno FROM station WHERE area = " + "'" +area + "'"; 
		        pstmt = conn.createStatement(); 
		        ResultSet rs = pstmt.executeQuery(sql);  
	            String no;     
		        while(rs.next()) 
		        {
		            no = rs.getString(1);
		            out.println("<html><body>" + "<h1>Ph no of " + area +": "+ no + "</body><html>"); 	        
		        } 
		        	out.close(); 
		    } catch (Exception e) { 
		    	System.out.println("ERROR"+e);
	  	 	        out.close();
	  	 	 }  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
