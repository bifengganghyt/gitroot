package gz.itcast.a_filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * ��һ��������
 * @author S43W
 *
 */
public class FirstFilter implements Filter {
	
	public FirstFilter() {
		System.out.println("1)���������󴴽���!");
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2)��������ʼ������");
		
		//��ȡ��ʼ������
		System.out.println(filterConfig.getInitParameter("AAA"));
		//�������в���
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		while (enums.hasMoreElements()) {
			String paramName =  enums.nextElement();
			String paramValue = filterConfig.getInitParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}

	}
	
	/**
	 * ִ�й�������
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("3)����������ִ�й�������-��������");
		
		//����
		chain.doFilter(request, response);
		System.out.println("5)����������ִ�й�������--������Ӧ");

	}

	public void destroy() {
		System.out.println("4)��������������!");
	}
}
