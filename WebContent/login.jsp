<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页面</title>
<link href="Style/login.css" rel="stylesheet" type="text/css" />
<script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>
<body>
    <div class="logincontent">
        <h1>南昌大学教务管理系统</h1>
        <span style="color:red;">&nbsp;${msg}&nbsp;</span>
        <form action="${pageContext.request.contextPath}/userLogin.action" method="post">
            <div class="user">
                <label for="username">账号：</label>
                <input type="text" id="username" name="username" value="${username}"><br>
                <label for="password">密码：</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="logbox">
                <input type="checkbox" name="login" value="login" checked="checked"><small> 记住登录信息</small>
            </div>
            <div>
            <input type="submit" value="登 &nbsp;&nbsp;&nbsp;&nbsp;录" class="btnlogin"/>
            </div>
        </form>
    </div>
</body>
</html>
