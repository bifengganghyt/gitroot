package junit.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.action.UserAction;

public class ActionTest {
	
	//不从IOC获取对象
	//报空指针异常
	/*@Test
	public void test1() {
		UserAction userAction = new UserAction();
		userAction.execute();
	}*/
	
	//从IOC容器获取对象
	@Test
	public void test2() {
		// 容器对象(加载applicationContext.xml配置文件)
		//调用了setUserDao和setUserService方法
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取对象
		UserAction userAction = (UserAction)ac.getBean("userAction");
		userAction.execute();
	}

}
