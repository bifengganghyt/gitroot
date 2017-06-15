package c_life;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeDemo extends HttpServlet{
	
	/**
	 * 1)构造方法。servlet对象创建时调用的
	 */
	public LifeDemo() {
		System.out.println("servlet对象被创建了");
	}
	
	/**
	 * 2)初始化方法
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init方法被调用");
	}	
	
	/**
	 * 3)服务方法
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		//super.service(arg0, arg1);
		System.out.println("service方法被调用");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet对象被销毁了");
	}

    /*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		System.out.println("doGet方法被调用");
	}*/
}
