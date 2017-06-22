package gz.itcast.web;

import gz.itcast.entity.User;
import gz.itcast.framework.Action;
import gz.itcast.service.UserService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		
		//1)��ȡ�û�����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//����javabean����
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		//2)����ҵ�񷽷�
		UserService  service = new UserService();
		User loginUser = service.login(user);
		if(loginUser==null) {
			//û�д��û�,��¼���ɹ�,������ͼ��ַ
			//�����ض����ת��
			//   redirect:/erorr.jsp  �����ض���
			//  /error.jsp   Ĭ����ת��
			return "input";
		} else {
			//���û����ݱ��浽session����
			//��¼�ɹ�,������ͼ��ַ
			return "success";
		}
	}
}
