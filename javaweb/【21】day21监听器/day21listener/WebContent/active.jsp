<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="gz.itcast.d_session.MyHttpSessionBindingListener"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HttpSessionBindingListener</title>
</head>
<body>
<!-- MyHttpSessionBindingListener对象放进、移出session 或者启动 关闭服务器都会触发MyHttpSessionBindingListener的Listener 事件 -->
<%
	MyHttpSessionBindingListener personInfo = (MyHttpSessionBindingListener)session.getAttribute("personInfo");
	if(personInfo == null) {
		personInfo = new MyHttpSessionBindingListener();
		personInfo.setName("Helloween");
		session.setAttribute("personInfo", personInfo);//当对象被放进session里是执行valueBound(HttpSessionBindingEvent event)方法
		out.println("PersonInfo 对象不存在。已经成功新建。sessionId: " + session.getId());
	} else {
		out.println("PersonInfo 对象存在。无需新建。sessionId: " + session.getId());
	}
%>
</body>
</html>