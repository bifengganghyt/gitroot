package gz.itcast.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有业务请求标准的接口
 * @heyutong
 * 2017年6月21日
 */
public interface Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
