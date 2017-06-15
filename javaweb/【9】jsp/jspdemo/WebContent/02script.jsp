<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp语法</title>
</head>
<body>
	<!-- JSP脚本,java语句 -->
	<%
		String name = "eric";
		int a = 10;
		int b = 20;
	%>
	<!-- jsp表达式 -->
	<%=name%><br>
	<%=(a+b) %>
	<!-- jsp脚本 -->
	<%
		Random random = new Random();
		float num = random.nextFloat();
		out.write("随机小数：" + num);
	%>
	<hr>
	<%
		for(int i=1;i<=6;i++) {
	%>
		<h<%= i %>>标题<%=i %></h<%=i %>>
	<%
		}
	%>
	<hr>
	
	<%--练习： 99乘法表 --%>
	<%
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
	%>
				<%=1 %>*<%=j %>=<%=(i*j) %>
				
		<%		
		}
		%>
		<br/>
	<%
		}
	%>
	
	 <!-- jsp声明 -->
	 <%!
	 	//声明变量
	 	String email = "eric@qq.com"; 
	 	//声明方法
	 	public void sayHello() {
	 		System.out.print("xxxxx");
	 	}
	 %>
	 
	 <%
       		/**注意：jsp脚本不能声明方法的
       		public void sayHello(){
      	  		System.out.print("xxxxx");
      	  	} 
      	  	*/
      %>
      <hr/>
        <!-- html注释 -->
        <%-- jsp注释--%>
		<%--<jsp:forward page="/01.hello.jsp"></jsp:forward> --%>
</body>
</html>