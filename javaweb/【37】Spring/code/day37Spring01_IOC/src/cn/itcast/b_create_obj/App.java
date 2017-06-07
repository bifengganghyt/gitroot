package cn.itcast.b_create_obj;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	@Test
	public void test() {
		// 方式1：创建容器对象
		/*ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create_obj/bean.xml");//打印:User.User(), 创建User对象...
		User user = (User) ac.getBean("user1");
		System.out.println(user);*/
		
		// 方式2： 会从当前类所在的包下找bean.xml  【测试方便】
		/*ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml", this.getClass());//打印:User.User(), 创建User对象...
		String str = (String)ac.getBean("str");
		System.out.println(str);//打印:Jack*/
		
		// 方式2： 会从当前类所在的包下找bean.xml  【测试方便】
		/*ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml", this.getClass());//打印:User.User(), 创建User对象...
		User user = (User) ac.getBean("user");
		System.out.println(user);//打印:User [id=10000, name=Jack]*/	

		//方式2： 会从当前类所在的包下找bean.xml  【测试方便】
		//打印:(1)调用getStaticInstace方法   (2)调用User(int id, String name)构造方法
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml", this.getClass());
		User user = (User) ac.getBean("user1");
		System.out.println(user);//User [id=101, name=工厂静态方法，创建对象]
	}
}
