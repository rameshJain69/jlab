
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/q5")
public class q5 extends HttpServlet {
       
   
    public String initials(String s) {
    	String ans = "";
    	int flag = 1;
    	for(int i = 0; i < s.length(); i++) {
    		if(flag == 1) {
    			ans += s.charAt(i);
    			flag = 0;
    		}
    		if(s.charAt(i) == ' ') {
    			flag = 1;
    		}
    	}
    	
    	return ans;
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String ans = "";
		String names = req.getParameter("names");
		ans = initials(names);
		
		out.print("<h1>" + ans + "</h1>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
