<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="com.baizhi.util.jsp" %>
<html>
<head>
    <script type="text/javascript" src="${prc}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
           $.post("${prc}/books/showHot",function(result){
               for(var i = 0;i<result.length;i++){
                   var li = ("<li/>");
                   console.log(result[i]);
                   $("#bookHot"),append(li).text(result[i]);
               }
           },"JSON")});
    </script>
</head>
<body>
    <h1>展示图书</h1>
        <c:forEach items="${requestScope.books}" var="book" >
            <img style="width: 150px;height: 150px;" src="${book.imgPath}" />
            书名：${book.name},
            作者：${book.author},
            页数：${book.pageNumber},
            价格：${book.price},
            介绍：${book.message}
            <a href="${prc}/cart/addCartItem">加入购物车</a><br/>
        </c:forEach>
    <hr>
    <br/>
    <span>添加图书</span><br/>
        <a href="${prc}/others/addBook.jsp">添加书本</a>
    <br/>
    <hr>
    <br/>
        <h1>热销图书</h1>
    <div >
        <ul id="bookHot"></ul>
    </div>
</body>
</html>
