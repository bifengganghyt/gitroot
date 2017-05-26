package gz.itcast.c_request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
/**
 * ServetRequest�ļ�����
 * @heyutong
 * 2017��5��26��
 */
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	
	/**
	 * ���ڼ���request����Ĵ���
     */
    public void requestInitialized(ServletRequestEvent arg0)  {
    	System.out.println("һ��������󱻴�����");
    	
    	//�õ����������ص���Ϣ
    	HttpServletRequest request = (HttpServletRequest)arg0.getServletRequest();
    	//�õ��ͻ���ip��ַ
    	String ip = request.getRemoteHost();
    }
	
	/**
	 * ���ڼ���request���������
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("һ���������������");
    }

	/**
	 * �������
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
    	String name = arg0.getName();
    	Object value = arg0.getValue();
    	System.out.println("�������ӣ�"+name+"="+value);
    }

    public void attributeRemoved(ServletRequestAttributeEvent arg0)  {
    	String name = arg0.getName();
		Object value = arg0.getValue();
		System.out.println("����ɾ����"+name+"="+value);
    }

    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
    	String name = arg0.getName();
		ServletRequest request = arg0.getServletRequest();
		Object value = request.getAttribute(name);
		System.out.println("�����޸ģ�"+name+"="+value);
    }
}
