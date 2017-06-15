package g_thread;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 【context对象的作用1】-获取web上下文路径
 * @heyutong
 * 2017年4月25日
 */
public class ContextDemo2 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 得到全局参数
		 */
		ServletContext context = this.getServletContext();
		
		String initParameter = context.getInitParameter("AAA");
		System.out.println(initParameter);
		
		//遍历所有参数
		Enumeration<String> enums = context.getInitParameterNames();
		while(enums.hasMoreElements()) {
			String paramName = enums.nextElement();
			String paramValue = context.getInitParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}
	}
}
