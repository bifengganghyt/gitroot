package gz.itcast.b_path;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	//��¼����
	public String login() {
		System.out.println("UserAction3.login()");
		return "login";
	}
	
	//ע�᷽��
	public String register() {
		System.out.println("UserAction3.register()");
		return "register";
	}
}
