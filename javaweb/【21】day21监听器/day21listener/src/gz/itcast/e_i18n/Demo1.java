package gz.itcast.e_i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {
	
	public static void main(String[] args) {
		//1)ʹ��ResuorceBundle����ز�ͬ����Դ��
		/**
		 * ����һ�� ��Դ������(ָ����Դ����) Ĭ��ָ����·���ĸ�Ŀ¼
		 * ������������locale
		 * ��Դ��+_����_����.properties
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.CHINA);//Locale.CHINA:"zh", "CN"
		//ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.UK);//Locale.UK:"en", "GB"
		//ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.US);//Locale.US:"en", "US"
		
		System.out.println(bundle.getString("username"));
		System.out.println(bundle.getString("password"));
		System.out.println(bundle.getString("login"));
	}
}
