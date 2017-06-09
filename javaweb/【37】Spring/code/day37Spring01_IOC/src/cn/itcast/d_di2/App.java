package cn.itcast.d_di2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",App.class);
	
	@Test
	public void testApp() throws Exception {
		//从容器中获取Action实例
		UserAction userAction = (UserAction) ac.getBean("userAction");
		System.out.println(userAction);//cn.itcast.d_di2.UserAction@caf446
		// 执行方法
		userAction.execute();//打印:UserDao.save()
		
		System.out.println("----------------");
		
		userAction = (UserAction)ac.getBean("userAction");//cn.itcast.d_di2.UserAction@6b2325
		System.out.println(userAction);
		userAction.execute();//打印:UserDao.save()
		
	}
}
