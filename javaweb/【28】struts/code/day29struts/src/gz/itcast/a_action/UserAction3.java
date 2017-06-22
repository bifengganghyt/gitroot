package gz.itcast.a_action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *  第三种方式： 继承ActionSupport类(推荐使用)
 * 	好处： 
 * 	1）提供了常用的视图标记
 * 	2）提供了数据校验功能
 * @heyutong
 * 2017年6月22日
 */
public class UserAction3 extends ActionSupport{
	public String login() {
		System.out.println("UserAction3.login()");
		return SUCCESS;
	}
}
