package gz.itcast.e_i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {
	
	public static void main(String[] args) {
		//1)使用ResuorceBundle类加载不同的资源包
		/**
		 * 参数一： 资源包名称(指向资源包名) 默认指向类路径的根目录
		 * 参数二：国家locale
		 * 资源名+_语言_国别.properties
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.CHINA);//Locale.CHINA:"zh", "CN"
		//ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.UK);//Locale.UK:"en", "GB"
		//ResourceBundle bundle = ResourceBundle.getBundle("message", Locale.US);//Locale.US:"en", "US"
		
		System.out.println(bundle.getString("username"));
		System.out.println(bundle.getString("password"));
		System.out.println(bundle.getString("login"));
	}
}
