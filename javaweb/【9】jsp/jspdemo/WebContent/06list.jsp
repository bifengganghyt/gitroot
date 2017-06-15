<%@page import="gz.itcast.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户列表</title>
</head>
<body>
	<table border="1" align="center" width="500px">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>密码</th>
    	</tr>
    	<%
    		//从request域中获取list数据
    		List<User> list =  (List<User>)request.getAttribute("list");
    		for(User user:list) {
    	%>
    	<tr>
    		<td><%=user.getId() %></td>
    		<td><%=user.getName() %></td>
    		<td><%=user.getPassword() %></td>
    	</tr>
		<%
    		}
		%>
	</table>
</body>
</html>