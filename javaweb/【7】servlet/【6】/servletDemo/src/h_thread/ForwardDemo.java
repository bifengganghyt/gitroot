package h_thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @heyutong
 * 2017年4月25日
 */
public class ForwardDemo   extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//注意：转发只能转发都当前项目的资源
		//this.getServletContext().getRequestDispatcher("../day08/adv.html").forward(request, response);

        //把数据保存到request域对象
		request.setAttribute("name", "jacky");
		
        //转发：服务器行为
		//this.getServletContext().getRequestDispatcher("/GetDataServlet").forward(request, response);
        //简写方式
		request.getRequestDispatcher("/GetDataServlet").forward(request, response);
	}
}
