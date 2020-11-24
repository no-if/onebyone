<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/register" method="post">  
<p>登录ID<input type="text" name="loginId" placeholder="登录ID"></p>
<p>姓名<input type="text" name="userName" placeholder="姓名"></p>
<p>邮箱<input type="email" name="userEmail" placeholder="邮箱" > </p> 
<p>密码<input type="password" name="userPassword" placeholder="密码" > </p> 



<p><input type="reset" value="重置"></p>

<p><input type="submit"  value="提交注册"></p>

 

 
</form>

</body>
</html>