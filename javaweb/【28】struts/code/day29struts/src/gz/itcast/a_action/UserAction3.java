package gz.itcast.a_action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *  �����ַ�ʽ�� �̳�ActionSupport��(�Ƽ�ʹ��)
 * 	�ô��� 
 * 	1���ṩ�˳��õ���ͼ���
 * 	2���ṩ������У�鹦��
 * @heyutong
 * 2017��6��22��
 */
public class UserAction3 extends ActionSupport{
	public String login() {
		System.out.println("UserAction3.login()");
		return SUCCESS;
	}
}
