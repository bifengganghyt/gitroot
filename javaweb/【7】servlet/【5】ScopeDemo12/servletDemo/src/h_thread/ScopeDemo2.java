package h_thread;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @heyutong
 * 2017Äê4ÔÂ25ÈÕ
 */
public class ScopeDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		//Object attribute = context.getAttribute("list");
		List list = (List)context.getAttribute("list");
		
		System.out.println("get list=" + list.toString());
	}
}
