package gz.itcast.a_action;

/**
 * 第一种方式：不需要实现或继承任何接口或类
 * @heyutong
 * 2017年6月22日
 */
public class UserAction2 {
	public String login() {
		System.out.println("UserAction2.login()");
		return "success";
	}

}
