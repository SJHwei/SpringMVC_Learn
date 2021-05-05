<%--
  Created by IntelliJ IDEA.
  User: SJHwei
  Date: 2021/4/8
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>

    <%--为什么一点这个超链接就能执行HelloController类中的那个方法呢？所以需要一个注解@RequestMapping--%>
<%--    <a href="hello">入门程序</a>--%>
    <a href="user/testRequestMapping?username=heihei">RequestMapping</a>
</body>
</html>
