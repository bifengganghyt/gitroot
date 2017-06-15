package gz.itcast.a_url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDataServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream in = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = in.read(buf)) != -1) {
			String str = new String(buf, 0 ,len);
			System.out.println("URL解码前" + str);
			
			//使用URL解密工具
			str = URLDecoder.decode(str, "utf-8");
			System.out.println("URL解码后" + str);
		}
	}
}
