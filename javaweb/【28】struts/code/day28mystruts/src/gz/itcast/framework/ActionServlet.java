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
	//设计一个专门读取mystruts.xml文件的类
	ConfigurationManager manager;

	/*@Override
	public void init() throws ServletException {
		//初始化mystruts.xml文件，封装对象
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
		//从配置管理器类中获取所有的ActionMapping对象
		Map<String, ActionMapping> actionMappings = manager.getActionMappings();
		
		//1)获取用户的请求 （login.action  / register.action ......）
		String uri = request.getRequestURI();//   /day28mystruys/login.action
		
		String pathName = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		
		//在所有ActionMapping中搜对应name的ActionMaping
		if(!actionMappings.containsKey(pathName)) {
			throw new RuntimeException("找不到对应的Action");
		}
		
		//取出ActionMapping
		ActionMapping actionMapping = actionMappings.get(pathName);
		
		//构造Action对象
		String className = actionMapping.getClassName();
		
		
			Class clazz  = Class.forName(className);
			Object actionObj = clazz.newInstance();
			
			//执行方法
			String methodName = actionMapping.getMethod();
			Method actionMethod = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			//得到视图的标记
			String resultFlag  = (String)actionMethod.invoke(actionObj, request, response);
			
			//3)得到视图
			Map<String, Result> results = actionMapping.getResults();
			if(!results.containsKey(resultFlag)) {
				throw new RuntimeException("找不到对应的Result视图");
			}
			
			Result result = results.get(resultFlag);
			
			//4)跳转视图
			//跳转类型
			String type = result.getType();
			
			//跳转的页面
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
