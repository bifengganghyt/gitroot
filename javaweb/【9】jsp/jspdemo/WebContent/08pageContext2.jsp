<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP '08.pageContext2.jsp' starting page</title>
</head>
<body>
	<%
		String message = (String)pageContext.getAttribute("message");
		out.write("pages' message="+message+"<br/>");
		//2)从其他域中取出
		message = (String)pageContext.getAttribute("message",PageContext.REQUEST_SCOPE);
		out.write("request's message="+message+"<br/>");
    	message = (String)pageContext.getAttribute("message",PageContext.SESSION_SCOPE);
    	out.write("session's message="+message+"<br/>");
    	message = (String)pageContext.getAttribute("message",PageContext.APPLICATION_SCOPE);
    	out.write("application's message="+message+"<br/>");
	%>
</body>
</html>