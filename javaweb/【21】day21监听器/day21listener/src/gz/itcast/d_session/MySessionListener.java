package gz.itcast.d_session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession����ļ�����
 * @heyutong
 * 2017��5��26��
 */
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	//���ڴ洢��ǰ��վ�ķÿ�����
	private int count = 0;
	
	 public void sessionCreated(HttpSessionEvent arg0)  { 
	    	System.out.println("һ��session���󱻴�����"+arg0.getSession());
	    	ServletContext context = arg0.getSession().getServletContext();
	    	
	    	//ʹ�ô���ͬ��������Ϊ����û�ͬʱ���������Ĳ������⣨����count���������ԣ�
	    	synchronized (MySessionListener.class) {// ע�⣺����Ӧ����Ψһ�ģ���������Ψһ��
	    		count++;
	    		//��countͨ��context�������jspҳ��
				//����ͨ��session�����ȡ��ServletContext�����
	    		context.setAttribute("onLine", count);
			}
	    }
	    
	    /**
	     * ���ڼ���HttpSession���������
	     * ���û���Ӧ��session���������ˣ��������������
	     */
	    public void sessionDestroyed(HttpSessionEvent arg0)  { 
	    	System.out.println("һ��session����������"+arg0.getSession());
	    	ServletContext context = arg0.getSession().getServletContext();
	    	
	    	synchronized (MySessionListener.class) {
	    		count--;
	    		context.setAttribute("onLine", count);
			}
	    }
	
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	String name = arg0.getName();
		Object value = arg0.getValue();
		System.out.println("�������ӣ� "+name+"="+value);
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	String name = arg0.getName();
		HttpSession session = arg0.getSession();
		Object value = session.getAttribute(name);
		System.out.println("�����޸ģ� "+name+"="+value);
    }
    
    public void attributeRemoved(HttpSessionBindingEvent arg0)  {
    	String name = arg0.getName();
		Object value = arg0.getValue();
		System.out.println("����ɾ���� "+name+"="+value);
    }
}
