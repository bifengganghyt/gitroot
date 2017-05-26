package gz.itcast.d_cases;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//准备内容
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=1;i<=3000;i++) {
			stringBuffer.append("abcd");
		}
		
		/**
		 * 注意：每次写出的网页内容都是已经经过gzip压缩的内容
		 *   思路：
		 *   	1）现在response对象的getWriter()方法得到的是没有缓冲功能的PrintWriter()，
		 *   	 调用write()方法就是直接把内容输出到浏览器显示。  
		 *     2）如果我们通过改造response对象的getWriter方法，从而得到一个带有缓存功能的PrintWriter对象，
		 *      那么write写出的网页内容就是写出到PrintWriter缓存区中，我们就可以从PrintWriter的缓存区中得到网页内容
		 */
		response.getWriter().write(stringBuffer.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
