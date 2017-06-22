package gz.itcast.web;

import gz.itcast.entity.User;
import gz.itcast.framework.Action;
import gz.itcast.service.UserService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction implements Action{
	
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		//1)��ȡ�û�����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//��װjavabean����
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		//2)����ҵ�񷽷�
		UserService  service = new UserService();
		service.register(user);
		
		//3)������ͼ
		return "success";
	}
}
