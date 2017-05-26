package gz.itcast.b_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext�ļ�����
 * @author APPle
 *����
 *	1������Ŀ������ʱ�򣬳�ʼ����
 *  2������Ŀ������ʱ��ɾ����
 */
public class MyContextListener implements ServletContextListener,ServletContextAttributeListener{

	SystemDao dao = new SystemDao();
	/**
	 * �÷������ڼ���ServletContext����Ĵ�����Ϊ
	 */
	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * ��ʼ��
		 */
		dao.initTable();
		System.out.println("��ʼ���ɹ�");
	}
	/**
	 * �÷������ڼ���ServletContext�����������Ϊ
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		/**
		 * �����
		 */
		dao.clearTable();
		System.out.println("����ɹ�");
	}
	
	/*********************������ص�**************************/
	/**
	 * ��������
	 */
	public void attributeAdded(ServletContextAttributeEvent scab) {
		//System.out.println("��������");
		//�õ�������
		String name = scab.getName();
		//�õ�����ֵ
		Object value = scab.getValue();
		System.out.println("�������ӣ� "+name+"="+value);
	}
	/**
	 * �����޸�
	 * @param scab
	 */
	public void attributeReplaced(ServletContextAttributeEvent scab) {//ServletContextAttributeEvent�Ѿ��������¼�Դ����
		//System.out.println("�����޸�");
		String name = scab.getName();
		//�õ��޸�ǰ������ֵ
		//Object value = scab.getValue();
		
		//�õ��޸ĺ������ֵ
		//��Ҫ��ServletContext�¼�Դ�����ٴλ�ȡ���ԣ��ſ��Եõ����µ�����ֵ��
		ServletContext context = scab.getServletContext();
		Object value = context.getAttribute(name);
		
		System.out.println("�����޸ģ� "+name+"="+value);
	}
	/**
	 * ����ɾ��
	 * @param scab
	 */
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		//System.out.println("����ɾ��");
		
		String name = scab.getName();
		//�õ�����ֵ
		Object value = scab.getValue();
		System.out.println("����ɾ���� "+name+"="+value);
	}
	

	

}
