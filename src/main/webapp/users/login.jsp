<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@include file="com.baizhi.util.jsp" %>
<html>
<head>

</head>
<body>
    <form action="${prc}/user/loginUser" method="post">
      <table style="margin-top: 70px;text-align: right;">
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" /><td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" /><td>
            </tr>
        </table>
            <input type="submit" value="登陆" />
            <a href="${prc}/users/regist.jsp">注册</a>
    </form>
</body>
</html>
