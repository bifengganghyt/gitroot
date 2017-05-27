package gz.itcast.d_session;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyHttpSessionBindingListener implements HttpSessionActivationListener, HttpSessionBindingListener,Serializable{

	/**
	 * @heyutong
	 * 2017年5月27日 
	 */
	private static final long serialVersionUID = 7015229037550697135L;
	
	Log log = LogFactory.getLog(getClass());
	
	private String name;
	private Date dateCreatedDate;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreatedDate() {
		return dateCreatedDate;
	}

	public void setDateCreatedDate(Date dateCreatedDate) {
		this.dateCreatedDate = dateCreatedDate;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName();//name = "personInfo"
		log.info(this + "被绑定到session \"" + session.getId() + "\"的" + name + "属性上");
		//MyHttpSessionBindingListener [log=org.apache.commons.logging.impl.Jdk14Logger@14c6b72, name=Helloween, dateCreatedDate=null]
		//被绑定到session "1DFC16F5EA14BDCEB546A730F36078A3"的personInfo属性上
		
		// 记录放到session中的时间
		this.setDateCreatedDate(new Date());
	}
	
	// 从session中移除后
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName();
		log.info(this + "被从session \"" + session.getId() + "\"的" + name+ "属性上移除");
	}
	
	//从硬盘加载后
	public void sessionDidActivate(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info(this + "已经成功从硬盘中加载.sessionId: " + session.getId());
	}
	
	// 即将被钝化到硬盘时
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info(this + "即将保存到硬盘。sessionId: " + session.getId());
	}

	@Override
	public String toString() {
		return "MyHttpSessionBindingListener [log=" + log + ", name=" + name
				+ ", dateCreatedDate=" + dateCreatedDate + "]";
	}
}
