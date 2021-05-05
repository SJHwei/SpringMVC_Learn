<%--
  Created by IntelliJ IDEA.
  User: SJHwei
  Date: 2021/4/20
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>文件上传</h3>

    <%--你去提交表单，其实我所有的内容最终全部会被封装到request这个对象里面来，所以得解析我的request，从而拿到上传文件的这个选项，
    那么如果拿到request，在对应的方法的参数中写上HttpServletRequest request--%>
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /> <br/>
        <input type="submit" value="上传" />
    </form>

    <h3>SpringMVC文件上传</h3>

    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /> <br/>
        <input type="submit" value="上传" />
    </form>

    <h3>跨服务器文件上传</h3>

    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload" /> <br/>
        <input type="submit" value="上传" />
    </form>

</body>
</html>
