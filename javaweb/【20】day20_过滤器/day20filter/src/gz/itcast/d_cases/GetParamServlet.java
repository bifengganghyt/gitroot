package gz.itcast.d_cases;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ҵ���servlet
 * @heyutong
 * 2017��5��23��
 */
public class GetParamServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ҵ���servlet����request��getParameter����֮ǰ��
		//��дgetParameter��������д֮���ȡ�Ĳ������Ǿ�����ȷ��ת������ݡ�
		String userName = request.getParameter("userName");
		System.out.println("ת����username:" + userName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
