<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userinfo" class="com.beans.Userinfo" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td align="center" colspan="2">注册信息</td>
	</tr>
	<tr>
		<td>用户名：</td>
		<td><jsp:getProperty property="username" name="userinfo"/></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><jsp:getProperty property="password" name="userinfo"/></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><jsp:getProperty property="sex" name="userinfo"/></td>
	</tr>
	<tr>
		<td>兴趣：</td>
		<td><jsp:getProperty property="hobby" name="userinfo"/></td>
	</tr>
</table>
</body>
</html>