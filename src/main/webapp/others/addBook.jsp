<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="com.baizhi.util.jsp" %>
<html>
<head>
    <script type="text/javascript" src="${prc}/js/jquery.min.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <form action="${prc}/books/insertBook" method="post" enctype="multipart/form-data">
        <table style="margin-top: 70px;text-align: left;align:center">
            <tr>
                <td>书名：</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>作者：</td>
                <td><input type="text" name="author" /></td>
            </tr>
            <tr>
                <td>价格：</td>
                <td><input type="text" name="price" /></td>
            </tr>
            <tr>
                <td>时间：</td>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <td>页数：</td>
                <td><input type="text" name="pageNumber"></td>
            </tr>
            <tr>
                <td>简介：</td>
                <td><input type="text" name="message"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="file" name="fileName" value="上传图片"></td>
            </tr>
        </table>
        <input type="submit" value="提交">
    </form>
</body>
</html>
