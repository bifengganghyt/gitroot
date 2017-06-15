package c_life;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeDemo extends HttpServlet{
	
	/**
	 * 1)���췽����servlet���󴴽�ʱ���õ�
	 */
	public LifeDemo() {
		System.out.println("servlet���󱻴�����");
	}
	
	/**
	 * 2)��ʼ������
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init����������");
	}	
	
	/**
	 * 3)���񷽷�
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		//super.service(arg0, arg1);
		System.out.println("service����������");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet����������");
	}

    /*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("doGet����������");
	}*/
}
