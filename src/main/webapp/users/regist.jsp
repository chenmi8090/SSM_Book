<%@ page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@include file="com.baizhi.util.jsp" %>
<html>
<head>
    <script type="text/javascript" src="${prc}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            var phone = $("#phone");
            $("#btn").click(function(){
                $.post("${prc}/user/send",phone,function (result) {
                    alert(result.message);
                },"JSON");
            });
        });
    </script>
</head>
<body>
    <form action="${prc}/user/insertUser" method="post">
        <table style="margin-top: 70px;text-align: right;">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" /><td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" /><td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" /><td>
            </tr>
            <tr>
                <td>电话:</td>
                <td><input type="text" id="phone" name="phone" /><td>
                <td><input id="btn" type="button" value="获取验证码" /></td>
            </tr>
            <tr>
                <td>验证码:</td>
                <td><input type="text" name="code" /><td>
            </tr>
        </table>
        <input type="submit" value="注册" />
    </form>
</body>
</html>
