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
 * 参数中文乱码问题的过滤器
 * @heyutong
 * 2017年5月23日
 */
public class EncodingFilter implements Filter {

	public void destroy() {

	}
	
	/**
	 * 执行过过滤任务
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//强制转换
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		
		//post提交参数
		httpServletRequest.setCharacterEncoding("utf-8");
		
		//创建一个HttpServletRequest实现类的装饰者类,重写getParameter方法
		MyHttpRequest myHttpRequest = new MyHttpRequest(httpServletRequest);
		/**
		 * 放行
		 * 注意：这里放行的应该是装饰后的request对象，这样在业务的servlet调用getParameter才是新的重写后的方法。
		 */
		chain.doFilter(myHttpRequest, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}

/**
 * 1)装饰者类
 * @heyutong
 * 2017年5月23日
 */
class MyHttpRequest extends HttpServletRequestWrapper {
	//2)声明一个被装饰者类型的成员变量
	private HttpServletRequest httpServletRequest;
	
	//3)接收被装饰者类对象
	public MyHttpRequest(HttpServletRequest request) {
		super(request);
		this.httpServletRequest = request;
	}
	
	//重写getParameter方法
	@Override
	public String getParameter(String name) {
		try {
			//对get提交参数处理
			//1)得到原来的参数
			String value = httpServletRequest.getParameter(name);//iso-8859-1
		
			//2）手动解码
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
