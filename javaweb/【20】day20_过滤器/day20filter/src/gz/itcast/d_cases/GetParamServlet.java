package gz.itcast.d_cases;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 业务的servlet
 * @heyutong
 * 2017年5月23日
 */
public class GetParamServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在业务的servlet调用request的getParameter方法之前，
		//重写getParameter方法，重写之后获取的参数都是经过正确的转码的内容。
		String userName = request.getParameter("userName");
		System.out.println("转码后的username:" + userName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
