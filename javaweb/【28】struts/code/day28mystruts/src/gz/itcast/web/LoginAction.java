package gz.itcast.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gz.itcast.framework.Action;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		//1)获取用户参数
		String name = request.getParameter("name");
		request.getParameter("password");
		
	}

}
