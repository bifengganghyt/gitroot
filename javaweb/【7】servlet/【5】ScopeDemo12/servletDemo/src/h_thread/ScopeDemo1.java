package h_thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @heyutong
 * 2017��4��25��
 */
public class ScopeDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�����ݴ洢��ServletContext�����
		ServletContext context = this.getServletContext();
		List list = new ArrayList();
		list.add("eric");
		list.add("jacky");
		list.add("rose");
		context.setAttribute("list", list);
		System.out.println("����ɹ�");
		
	}
}
