package gz.itcast.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ҵ�������׼�Ľӿ�
 * @heyutong
 * 2017��6��21��
 */
public interface Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
