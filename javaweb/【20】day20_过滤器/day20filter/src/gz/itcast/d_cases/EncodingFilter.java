package gz.itcast.d_cases;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
/**
 * ����������������Ĺ�����
 * @heyutong
 * 2017��5��23��
 */
public class EncodingFilter implements Filter {

	public void destroy() {

	}
	
	/**
	 * ִ�й���������
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//ǿ��ת��
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		
		//post�ύ����
		httpServletRequest.setCharacterEncoding("utf-8");
		
		//����һ��HttpServletRequestʵ�����װ������,��дgetParameter����
		MyHttpRequest myHttpRequest = new MyHttpRequest(httpServletRequest);
		/**
		 * ����
		 * ע�⣺������е�Ӧ����װ�κ��request����������ҵ���servlet����getParameter�����µ���д��ķ�����
		 */
		chain.doFilter(myHttpRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}

/**
 * 1)װ������
 * @heyutong
 * 2017��5��23��
 */
class MyHttpRequest extends HttpServletRequestWrapper {
	//2)����һ����װ�������͵ĳ�Ա����
	private HttpServletRequest httpServletRequest;
	
	//3)���ձ�װ���������
	public MyHttpRequest(HttpServletRequest request) {
		super(request);
		this.httpServletRequest = request;
	}
	
	//��дgetParameter����
	@Override
	public String getParameter(String name) {
		try {
			//��get�ύ��������
			//1)�õ�ԭ���Ĳ���
			String value = httpServletRequest.getParameter(name);//iso-8859-1
		
			//2���ֶ�����
			if("GET".equals(httpServletRequest.getMethod())) {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			}
			return value;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
