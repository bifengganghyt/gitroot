package gz.itcast.b_cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除同名cookie
 * @heyutong
 * 2017年4月27日
 */
public class CookieDemo2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("name", "abc");
		cookie.setMaxAge(0);//删除同名的cookie
		
		//发送cookie
		response.addCookie(cookie);
		System.out.println("删除成功！");
	}
}
