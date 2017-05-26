package gz.itcast.c_request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
/**
 * ServetRequest的监听器
 * @heyutong
 * 2017年5月26日
 */
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	
	/**
	 * 用于监听request对象的创建
     */
    public void requestInitialized(ServletRequestEvent arg0)  {
    	System.out.println("一个请求对象被创建了");
    	
    	//得到请求对象相关的信息
    	HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
    	//得到客户的ip地址
    	String ip = request.getRemoteHost();
    }
	
	/**
	 * 用于监听request对象的销毁
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("一个请求对象被销毁了");
    }

	/**
	 * 属性相关
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
    	String name = arg0.getName();
    	Object value = arg0.getValue();
    	System.out.println("属性增加："+name+"="+value);
    }

    public void attributeRemoved(ServletRequestAttributeEvent arg0)  {
    	String name = arg0.getName();
		Object value = arg0.getValue();
		System.out.println("属性删除："+name+"="+value);
    }

    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
    	String name = arg0.getName();
		ServletRequest request = arg0.getServletRequest();
		Object value = request.getAttribute(name);
		System.out.println("属性修改："+name+"="+value);
    }
}
