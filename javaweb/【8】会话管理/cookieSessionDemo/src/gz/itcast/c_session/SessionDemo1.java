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
		
		//把数据保存到HttpSession对象中
		//1)创建HttpSession对象
		HttpSession session = request.getSession(true);
		
		//设置session有效时间
		session.setMaxInactiveInterval(20);
		
		//设置JSESSIONID的时间，不会随着浏览器关闭而丢失！
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(1*30*24*60*60);//1个月
		response.addCookie(cookie);
		
		//2)保存会话数据
		session.setAttribute("name", "jacky");
	}
}
