package h_thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @heyutong
 * 2017��4��25��
 */
public class ResourceDemo  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //��ϰ�� ��ȡProperties�ļ���
		/**
		 * ���·������ǰ·�������java�������е�Ŀ¼
		 * ���ۣ���web��Ŀ�У�java�������е�Ŀ¼������tomcat��binĿ¼����web��Ŀ������ʹ�����·��
		 */
		/**
		FileInputStream in = new FileInputStream("./src/news.properties");
		//1)ʹ��Properteis����
		Properties prop = new Properties();
		//2)ʹ��load��������properties�ļ�
		prop.load(in);
		//3)ͨ��getProperty������ȡ����
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("password"));
		*/

		// 1)getRealPath()  ��ȡ��Դ�ļ�����ʵ·��
		@SuppressWarnings("unused")
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/news.properties");
		//System.out.println(path);
		//FileInputStream in = new FileInputStream(new File(path));
		
		//2)getResource() ��ȡ��Դ�ļ���URL
		URL url = this.getServletContext().getResource("/WEB-INF/classes/news.properties");
		
		//3)getResourceAsStream() ��ȡ��Դ�ļ���������
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/news.properties");
		//1)ʹ��Properteis����
		Properties prop = new Properties();
		//2)ʹ��load��������properties�ļ�
		prop.load(in);
		//3)ͨ��getProperty������ȡ����
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("password"));
	}
}
