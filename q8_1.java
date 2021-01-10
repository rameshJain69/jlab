import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		for(int i = 1; i <4; i++) {
			String nm = "Type1-CookieNo-" + i;
			String val = "Type1-CookieVal-" + i;
			Cookie ck = new Cookie(nm, val);
			response.addCookie(ck);
			nm = "Type2-CookieNo-" + i;
			val = "Type2-CookieVal-" + i;
			ck = new Cookie(nm, val);
			ck.setMaxAge(3600);
			response.addCookie(ck);
		}

		out.print("Cookies set");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
