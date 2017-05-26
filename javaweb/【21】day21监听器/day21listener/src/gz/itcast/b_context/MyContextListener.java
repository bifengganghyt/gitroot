package gz.itcast.b_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext的监听器
 * @author APPle
 *需求
 *	1）在项目启动的时候，初始化表
 *  2）在项目结束的时候，删除表
 */
public class MyContextListener implements ServletContextListener,ServletContextAttributeListener{

	SystemDao dao = new SystemDao();
	/**
	 * 该方法用于监听ServletContext对象的创建行为
	 */
	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * 初始表
		 */
		dao.initTable();
		System.out.println("初始化成功");
	}
	/**
	 * 该方法用于监听ServletContext对象的销毁行为
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		/**
		 * 清除表
		 */
		dao.clearTable();
		System.out.println("清除成功");
	}
	
	/*********************属性相关的**************************/
	/**
	 * 属性增加
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		//System.out.println("属性增加");
		//得到属性名
		String name = scab.getName();
		//得到属性值
		Object value = scab.getValue();
		System.out.println("属性增加： "+name+"="+value);
	}
	/**
	 * 属性修改
	 * @param scab
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {//ServletContextAttributeEvent已经包含了事件源对象
		//System.out.println("属性修改");
		String name = scab.getName();
		//得到修改前的属性值
		//Object value = scab.getValue();
		
		//得到修改后的属性值
		//需要从ServletContext事件源对象再次获取属性，才可以得到最新的属性值。
		ServletContext context = scab.getServletContext();
		Object value = context.getAttribute(name);
		
		System.out.println("属性修改： "+name+"="+value);
	}
	/**
	 * 属性删除
	 * @param scab
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		//System.out.println("属性删除");
		
		String name = scab.getName();
		//得到属性值
		Object value = scab.getValue();
		System.out.println("属性删除： "+name+"="+value);
	}
	

	

}
