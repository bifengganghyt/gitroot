package gz.itcast.d_cases;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//׼������
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=1;i<=3000;i++) {
			stringBuffer.append("abcd");
		}
		
		/**
		 * ע�⣺ÿ��д������ҳ���ݶ����Ѿ�����gzipѹ��������
		 *   ˼·��
		 *   	1������response�����getWriter()�����õ�����û�л��幦�ܵ�PrintWriter()��
		 *   	 ����write()��������ֱ�Ӱ�����������������ʾ��  
		 *     2���������ͨ������response�����getWriter�������Ӷ��õ�һ�����л��湦�ܵ�PrintWriter����
		 *      ��ôwriteд������ҳ���ݾ���д����PrintWriter�������У����ǾͿ��Դ�PrintWriter�Ļ������еõ���ҳ����
		 */
		response.getWriter().write(stringBuffer.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
