package gz.itcast.b_chain;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * ��һ��������
 */
public class FirstFilter implements Filter {
	public void destroy() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * ִ�й�������
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("1)ִ�е�һ�����������������");
		//����
		/**
		 * FilterChian���ǹ������������������doFilter���������ǰ��������Ӧ������һ�������������û����һ�����������ͷ��ʵ�Ŀ����Դ�˻򷵻ظ��û���ʾ��
		 * ���������Ĺ���ִ��˳����web.xml�ļ��й�������filter-mapping��˳������ģ������õ��ȱ����ʵ���������
		 */
		chain.doFilter(request, response);
		System.out.println("5)ִ�еڶ�������������Ӧ����");
	}
}
