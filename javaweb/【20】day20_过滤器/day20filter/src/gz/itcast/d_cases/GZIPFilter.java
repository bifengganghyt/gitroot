package gz.itcast.d_cases;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 集中对网页内容进行gzip压缩
 * @heyutong
 * 2017年5月23日
 */
public class GZIPFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
