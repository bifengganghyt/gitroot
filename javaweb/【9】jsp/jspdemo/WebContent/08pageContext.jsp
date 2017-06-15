<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>pageContext对象</title>
</head>
<body>
	<%
		//作用一： 可以获取其他8个内置对象
		out.write("相等吗？" + (pageContext.getRequest() == request) + "<br/>");
		out.write("相等吗?"+(pageContext.getResponse()==response));
		out.write("<br/>");
		
		//作用二: 作为域对象
		
		//1)可以保存到page域中
    	//保存数据(默认情况下，保存到page域)
    	pageContext.setAttribute("message","page's message");
		
    	//2)保存到其他三个域中(request,session,application)
    	pageContext.setAttribute("message","request's message",PageContext.REQUEST_SCOPE);
    	//等价于： request.setAttribute("message","request's message");
    	
    	pageContext.setAttribute("message","session's message",PageContext.SESSION_SCOPE);
    	pageContext.setAttribute("message","application's message",PageContext.APPLICATION_SCOPE);
	
		//注意： 1）在哪个域中保存，就必须从哪个域中获取
    	
		//获取数据
		//1)从page域中取出
		String message = (String)pageContext.getAttribute("message");
		out.write("pages' message="+message+"<br/>");
		
		//2)从其他域中取出
    	message = (String)pageContext.getAttribute("message",PageContext.REQUEST_SCOPE);
    	out.write("request's message="+message+"<br/>");
    	
    	message = (String)pageContext.getAttribute("message",PageContext.SESSION_SCOPE);
    	out.write("session's message="+message+"<br/>");
    	
    	message = (String)pageContext.getAttribute("message",PageContext.APPLICATION_SCOPE);
    	out.write("application's message="+message+"<br/>");
    	
    	//3)自动从四个域中搜索数据
    	//搜索顺序： 从小到大： page->request->session->application
    	out.write("message=" + pageContext.findAttribute("message"));
    	
    	//跳转页面
    	//request.getRequestDispatcher("/08pageContext2.jsp").forward(request,response);
    	response.sendRedirect("/jspdemo/08pageContext2.jsp");
	
	%>

</body>
</html>