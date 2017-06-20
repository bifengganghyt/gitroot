package gz.itcast.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("执行了LoginAction的execute方法");
		ServletActionContext.getRequest().setAttribute("name", "eric");
		return "success";
	}
	
	public String login() {
		System.out.println("执行了LoginAction的login方法");
		//从request获取数据
		String name = (String)ServletActionContext.getRequest().getAttribute("name");
		System.out.println("name="+name);
		return "login";
	}
}
