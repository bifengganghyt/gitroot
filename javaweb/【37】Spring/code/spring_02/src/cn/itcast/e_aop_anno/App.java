package cn.itcast.e_aop_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	 private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml",getClass());
	
	//1.springIOC容器中获取对象，用实现接收？   报错！！！！！！！！！
	@Test
	public void testApp() throws Exception {
		//java.lang.ClassCastException:  $Proxy12 cannot be cast to cn.itcast.e_aop_anno.UserDao
		// 总结：在spring的aop编程中，符合切入点表达式的目标类，  如果目标对象有实现接口，从容器获取对象的时候，一定要通过接口接收！
		// 否则，包类型转换错误！
		/*UserDao userDao = (UserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());
		userDao.save();*/    
	}
	
	//cglib代理
	//2.springIOC容器中获取对象，用接口接收！
	@Test
	public void testApp_cglib() throws Exception {
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());//打印：class com.sun.proxy.$Proxy12
		userDao.save();//1:arround():打印"[环绕前：]" 2:执行beginTransaction() 2:UserDao.save 
						//3：[环绕后：]  4:commit() 5:afterReturing()
	}
	
	// 没有生成代理对象，因为没有被切入点表达式拦截
	// execution(* cn.itcast.e_aop_anno.UserDao.*(..))
	/*@Test
	public void testApp_save_order() throws Exception {
		OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
		System.out.println(orderDao.getClass());//打印:class cn.itcast.e_aop_anno.OrderDao
		orderDao.save();//打印:"保存订单.."
	}*/
}
