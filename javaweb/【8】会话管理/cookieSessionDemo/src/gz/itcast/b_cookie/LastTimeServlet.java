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
 * �ϴη���ʱ��
 * @heyutong
 * 2017��4��27��
 */
public class LastTimeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//������ǰʱ���ַ���
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		String curDate = simpleDateFormat.format(new Date());
		
		//��ȡcookie
		Cookie[] cookies = request.getCookies();
		String lastTime = null;
		
		//��һ�η���
		if(cookies == null && lastTime==null) {
			//2)��ʾ�������
			response.getWriter().write("��ӭ�״ι��ٱ���վ����ǰʱ��Ϊ��"+curDate);
			
			//3)�ѵ�ǰʱ�䱣�浽cookie��
			//�����ĸ�ʽ�������ַ������м���
			curDate = URLEncoder.encode(curDate, "utf-8");
			
			Cookie cookie = new Cookie("lastTime", curDate);
			
			//4)��cookie���͸������
			response.addCookie(cookie);
		}
		
		if(cookies!= null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lastTime")) {
				   lastTime =cookie.getValue();
				   //�ҵ��ˣ���n�η���
				   //lastTime�������ϴη��ʵ�ʱ��
				   //�������ַ������н���
				   lastTime = URLDecoder.decode(lastTime, "utf-8");
				   //��ʾ���ݸ������
				   response.getWriter().write("��ӭ�ٴι��ٱ���վ�����ϴη��ʵ�ʱ��Ϊ��"+lastTime+"<br/>��ǰ��ʱ��Ϊ��"+curDate);
					
				   //����cookie�ϴη��ʵ�ʱ��
					curDate = URLEncoder.encode(curDate, "utf-8");
					cookie.setValue(curDate);
					
					response.addCookie(cookie);
					break;
				}
			}
		}
		
	}
}
