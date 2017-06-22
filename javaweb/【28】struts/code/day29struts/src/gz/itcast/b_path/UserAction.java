package gz.itcast.b_path;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	//登录方法
	public String login() {
		System.out.println("UserAction3.login()");
		return "login";
	}
	
	//注册方法
	public String register() {
		System.out.println("UserAction3.register()");
		return "register";
	}
}
