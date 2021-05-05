<%--
  Created by IntelliJ IDEA.
  User: SJHwei
  Date: 2021/4/26
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--引入jstl的标签库--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>查询所有的账户</h3>

    <%--${list}--%>
    <%--显示一个遍历效果--%>
    <c:forEach items="${list}" var="account">
        ${account.name}
    </c:forEach>

</body>
</html>
