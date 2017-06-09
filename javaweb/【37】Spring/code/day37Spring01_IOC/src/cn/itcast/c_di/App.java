package cn.itcast.c_di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	@Test
	public void testApp() throws Exception {
		// 方式2： 会从当前类所在的包下找bean.xml  【测试方便】
		//调用了setId、setName、setList、setMap、setProp方法
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml",this.getClass());
		
		User user = (User) ac.getBean("user");
		//打印:User [id=1000, list=[cn, usa], 
		//map={cn=China, usa=1234}, name=Jacky, prop={usa=America, cn=China}]
		System.out.println(user);
	}
}
