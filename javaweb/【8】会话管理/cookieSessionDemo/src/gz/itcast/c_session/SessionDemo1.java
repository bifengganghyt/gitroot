package gz.itcast.c_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�����ݱ��浽HttpSession������
		//1)����HttpSession����
		HttpSession session = request.getSession(true);
		
		//����session��Чʱ��
		session.setMaxInactiveInterval(20);
		
		//����JSESSIONID��ʱ�䣬��������������رն���ʧ��
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(1*30*24*60*60);//1����
		response.addCookie(cookie);
		
		//2)����Ự����
		session.setAttribute("name", "jacky");
	}
}
