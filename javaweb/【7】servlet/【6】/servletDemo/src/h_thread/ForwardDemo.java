package h_thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @heyutong
 * 2017��4��25��
 */
public class ForwardDemo   extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ע�⣺ת��ֻ��ת������ǰ��Ŀ����Դ
		//this.getServletContext().getRequestDispatcher("../day08/adv.html").forward(request, response);

        //�����ݱ��浽request�����
		request.setAttribute("name", "jacky");
		
        //ת������������Ϊ
		//this.getServletContext().getRequestDispatcher("/GetDataServlet").forward(request, response);
        //��д��ʽ
		request.getRequestDispatcher("/GetDataServlet").forward(request, response);
	}
}
