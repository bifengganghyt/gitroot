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
 * 第一个过滤器
 * @author S43W
 *
 */
public class FirstFilter implements Filter {
	
	public FirstFilter() {
		System.out.println("1)过滤器对象创建了!");
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("2)过滤器初始化方法");
		
		//获取初始化参数
		System.out.println(filterConfig.getInitParameter("AAA"));
		//遍历所有参数
		Enumeration<String> enums = filterConfig.getInitParameterNames();
		while (enums.hasMoreElements()) {
			String paramName =  enums.nextElement();
			String paramValue = filterConfig.getInitParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}

	}
	
	/**
	 * 执行过滤任务
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("3)过滤器正在执行过滤任务-过滤请求");
		
		//放行
		chain.doFilter(request, response);
		System.out.println("5)过滤器正在执行过滤任务--过滤响应");

	}

	public void destroy() {
		System.out.println("4)过滤器被销毁了!");
	}
}
