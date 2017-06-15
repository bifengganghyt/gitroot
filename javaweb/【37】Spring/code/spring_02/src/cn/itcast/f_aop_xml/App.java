package cn.itcast.f_aop_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private ApplicationContext ac = new ClassPathXmlApplicationContext(
			"applicationContext.xml", getClass());

	@Test
	public void testApp() throws Exception {
		// springIOC容器中获取对象，用接口接收！
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());//class com.sun.proxy.$Proxy4
		//1:(arroud)[环绕前：] 2:(beginTransaction)[前置通知]  开启事务.. 3:(save)保存...  
		//4:(arroud)[环绕后：] 5:(commit)[后置通知] 提交事务.. 6:(afterReturing)[返回后通知]
		userDao.save();
	}
}
