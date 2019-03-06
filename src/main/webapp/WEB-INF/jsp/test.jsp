<%--
  Created by IntelliJ IDEA.
  User: liujiakuo
  Date: 2019/3/6
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<p>上传图片</p>
<form action="image/upload" method="POST" enctype="multipart/form-data">
    <input type="file" name="image"/>
    <input type="submit"/>
</form>
</body>
</html>
