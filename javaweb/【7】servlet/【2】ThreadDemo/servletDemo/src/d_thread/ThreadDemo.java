package d_thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadDemo extends HttpServlet{

	public ThreadDemo() {
		System.out.println("TheadDemo���󴴽���");
	}
	
	static int count = 1;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		synchronized ( ThreadDemo.class) {
			response.getWriter().write("�㵱ǰ�ǵ�"+count+"���ÿͣ�");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}	
	}
}
