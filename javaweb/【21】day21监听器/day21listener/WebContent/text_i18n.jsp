<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>web页面的文字国际化</title>  
  </head>
   <%--绑定资源包 --%>
   <fmt:setBundle basename="message"/>
  <body>
      <table align="left" border="1">
      	<tr>
      		<th><fmt:message key="username"></fmt:message>：</th>
      		<td><input type="text" name="userName"/></td>
      	</tr>
      	<tr>
      		<th><fmt:message key="password"></fmt:message>：</th>
      		<td><input type="password" name="userPwd"/></td>
      	</tr>
      	<tr>
      		<td><input type="submit" value="<fmt:message key="login"></fmt:message>"/></td>
      	</tr>
      	
      </table>
  </body>
</html>
