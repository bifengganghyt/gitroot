<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" buffer="0kb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP '07out.jsp' starting page</title>
</head>
<body>
	<%
		out.write("1");
		System.out.println("当前缓存区大小：" + out.getBufferSize());
		System.out.println("缓存区剩余的大小：" + out.getRemaining());
		//手动刷新
    	//out.flush();
		response.getWriter().write("abc");
	%>


</body>
</html>