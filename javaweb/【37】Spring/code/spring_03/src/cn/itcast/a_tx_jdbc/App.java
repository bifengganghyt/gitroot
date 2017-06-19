package cn.itcast.a_tx_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	@Test
	public void test() {
		//spring-context-3.2.5.RELEASE.jar
		//commons-logging-1.1.3.jar
		//spring-expression-3.2.5.RELEASE.jar
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",getClass());
		IDeptService deptService = (IDeptService) ac.getBean("deptService");
		deptService.save();
	}
}
