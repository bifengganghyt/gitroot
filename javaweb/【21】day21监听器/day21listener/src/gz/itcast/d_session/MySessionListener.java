package gz.itcast.d_session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession对象的监听器
 * @heyutong
 * 2017年5月26日
 */
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	//用于存储当前网站的访客人数
	private int count = 0;
	
	 public void sessionCreated(HttpSessionEvent arg0)  { 
	    	System.out.println("一个session对象被创建了"+arg0.getSession());
	    	ServletContext context = arg0.getSession().getServletContext();
	    	
	    	//使用代码同步避免因为多个用户同时访问引发的并发问题（导致count的数量不对）
	    	synchronized (MySessionListener.class) {// 注意：锁对应必须唯一的，类对象就是唯一的
	    		count++;
	    		//把count通过context域对象共享到jsp页面
				//可以通过session对象获取到ServletContext对象的
	    		context.setAttribute("onLine", count);
			}
	    }
	    
	    /**
	     * 用于监听HttpSession对象的销毁
	     * 当用户对应的session对象销毁了，代表访问离线了
	     */
	    public void sessionDestroyed(HttpSessionEvent arg0)  { 
	    	System.out.println("一个session对象被销毁了"+arg0.getSession());
	    	ServletContext context = arg0.getSession().getServletContext();
	    	
	    	synchronized (MySessionListener.class) {
	    		count--;
	    		context.setAttribute("onLine", count);
			}
	    }
	
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	String name = arg0.getName();
		Object value = arg0.getValue();
		System.out.println("属性增加： "+name+"="+value);
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	String name = arg0.getName();
		HttpSession session = arg0.getSession();
		Object value = session.getAttribute(name);
		System.out.println("属性修改： "+name+"="+value);
    }
    
    public void attributeRemoved(HttpSessionBindingEvent arg0)  {
    	String name = arg0.getName();
		Object value = arg0.getValue();
		System.out.println("属性删除： "+name+"="+value);
    }
}
