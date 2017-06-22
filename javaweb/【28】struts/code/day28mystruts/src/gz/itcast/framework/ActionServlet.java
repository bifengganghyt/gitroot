package gz.itcast.framework;

import gz.itcast.framework.bean.ActionMapping;
import gz.itcast.framework.bean.ConfigurationManager;
import gz.itcast.framework.bean.Result;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	//���һ��ר�Ŷ�ȡmystruts.xml�ļ�����
	ConfigurationManager manager;

	/*@Override
	public void init() throws ServletException {
		//��ʼ��mystruts.xml�ļ�����װ����
		manager = new ConfigurationManager();
	}*/
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//super.init(config);
		manager = new ConfigurationManager();
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		//�����ù��������л�ȡ���е�ActionMapping����
		Map<String, ActionMapping> actionMappings = manager.getActionMappings();
		
		//1)��ȡ�û������� ��login.action  / register.action ......��
		String uri = request.getRequestURI();//   /day28mystruys/login.action
		
		String pathName = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		
		//������ActionMapping���Ѷ�Ӧname��ActionMaping
		if(!actionMappings.containsKey(pathName)) {
			throw new RuntimeException("�Ҳ�����Ӧ��Action");
		}
		
		//ȡ��ActionMapping
		ActionMapping actionMapping = actionMappings.get(pathName);
		
		//����Action����
		String className = actionMapping.getClassName();
		
		
			Class clazz  = Class.forName(className);
			Object actionObj = clazz.newInstance();
			
			//ִ�з���
			String methodName = actionMapping.getMethod();
			Method actionMethod = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			//�õ���ͼ�ı��
			String resultFlag  = (String)actionMethod.invoke(actionObj, request, response);
			
			//3)�õ���ͼ
			Map<String, Result> results = actionMapping.getResults();
			if(!results.containsKey(resultFlag)) {
				throw new RuntimeException("�Ҳ�����Ӧ��Result��ͼ");
			}
			
			Result result = results.get(resultFlag);
			
			//4)��ת��ͼ
			//��ת����
			String type = result.getType();
			
			//��ת��ҳ��
			String page = result.getPage();
			if(type.equals("dispatcher")) {
				request.getRequestDispatcher(page).forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + page);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
