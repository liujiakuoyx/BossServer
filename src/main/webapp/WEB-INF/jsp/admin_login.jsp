<%--
  Created by IntelliJ IDEA.
  User: 佳阔
  Date: 2019/3/10
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登陆</title>
    <link rel="stylesheet" type="text/css" href="/css/admin_login_style.css"/>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body background="/img/login_back.jpg">

<div class="login_container">
    <div class="login_title">
        <p1>管理员登陆</p1>
    </div>
    <div class="login_edit_container1">
        账号:&nbsp&nbsp&nbsp<input type="text" placeholder="请输入您的账号" name="uid"/>
    </div>
    <div class="login_edit_container2">
        密码:&nbsp&nbsp&nbsp<input type="password" placeholder="请输入您的密码" name="upass"/>
    </div>
    <div class="login_div">
        <input type="submit" class="login" value="登 录" name="login_button" onclick="login()">
    </div>
</div>
</body>
<script>
    function login() {
        var uid = $("input[name='uid']").val();
        var upass = $("input[name='upass']").val();
        $.ajax({
            type: "get",
            url: '/admin/doLogin.do',
            contentType: "text/html; charset=utf-8",
            data: {
                'uid': uid,
                'upass': upass
            },
            success: function (data) {
                console.log(JSON.stringify(data));
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    }
</script>
</html>
