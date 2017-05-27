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
	 * 2017��5��27�� 
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
		log.info(this + "���󶨵�session \"" + session.getId() + "\"��" + name + "������");
		//MyHttpSessionBindingListener [log=org.apache.commons.logging.impl.Jdk14Logger@14c6b72, name=Helloween, dateCreatedDate=null]
		//���󶨵�session "1DFC16F5EA14BDCEB546A730F36078A3"��personInfo������
		
		// ��¼�ŵ�session�е�ʱ��
		this.setDateCreatedDate(new Date());
	}
	
	// ��session���Ƴ���
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName();
		log.info(this + "����session \"" + session.getId() + "\"��" + name+ "�������Ƴ�");
	}
	
	//��Ӳ�̼��غ�
	public void sessionDidActivate(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info(this + "�Ѿ��ɹ���Ӳ���м���.sessionId: " + session.getId());
	}
	
	// �������ۻ���Ӳ��ʱ
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		log.info(this + "�������浽Ӳ�̡�sessionId: " + session.getId());
	}

	@Override
	public String toString() {
		return "MyHttpSessionBindingListener [log=" + log + ", name=" + name
				+ ", dateCreatedDate=" + dateCreatedDate + "]";
	}
}
