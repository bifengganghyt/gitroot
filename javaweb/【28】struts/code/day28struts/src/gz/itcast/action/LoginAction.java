package gz.itcast.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("ִ����LoginAction��execute����");
		ServletActionContext.getRequest().setAttribute("name", "eric");
		return "success";
	}
	
	public String login() {
		System.out.println("ִ����LoginAction��login����");
		//��request��ȡ����
		String name = (String)ServletActionContext.getRequest().getAttribute("name");
		System.out.println("name="+name);
		return "login";
	}
}
