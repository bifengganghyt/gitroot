package gz.itcast.b_cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上次访问时间
 * @heyutong
 * 2017年4月27日
 */
public class LastTimeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//制作当前时间字符串
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd号 hh时mm分ss秒");
		String curDate = simpleDateFormat.format(new Date());
		
		//获取cookie
		Cookie[] cookies = request.getCookies();
		String lastTime = null;
		
		//第一次访问
		if(cookies == null && lastTime==null) {
			//2)显示到浏览器
			response.getWriter().write("欢迎首次光临本网站，当前时间为："+curDate);
			
			//3)把当前时间保存到cookie中
			//对中文格式的日期字符串进行加密
			curDate = URLEncoder.encode(curDate, "utf-8");
			
			Cookie cookie = new Cookie("lastTime", curDate);
			
			//4)把cookie发送给浏览器
			response.addCookie(cookie);
		}
		
		if(cookies!= null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lastTime")) {
				   lastTime =cookie.getValue();
				   //找到了，第n次访问
				   //lastTime保存了上次访问的时间
				   //对日期字符串进行解密
				   lastTime = URLDecoder.decode(lastTime, "utf-8");
				   //显示内容给浏览器
				   response.getWriter().write("欢迎再次光临本网站，您上次访问的时间为："+lastTime+"<br/>当前的时间为："+curDate);
					
				   //更新cookie上次访问的时间
					curDate = URLEncoder.encode(curDate, "utf-8");
					cookie.setValue(curDate);
					
					response.addCookie(cookie);
					break;
				}
			}
		}
		
	}
}
