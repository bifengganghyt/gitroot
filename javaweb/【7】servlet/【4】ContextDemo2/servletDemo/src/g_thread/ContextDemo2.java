package g_thread;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��context���������1��-��ȡweb������·��
 * @heyutong
 * 2017��4��25��
 */
public class ContextDemo2 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * �õ�ȫ�ֲ���
		 */
		ServletContext context = this.getServletContext();
		
		String initParameter = context.getInitParameter("AAA");
		System.out.println(initParameter);
		
		//�������в���
		Enumeration<String> enums = context.getInitParameterNames();
		while(enums.hasMoreElements()) {
			String paramName = enums.nextElement();
			String paramValue = context.getInitParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}
	}
}
