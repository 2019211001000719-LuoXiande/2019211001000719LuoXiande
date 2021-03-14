<%--
  Created by IntelliJ IDEA.
  User: 17497
  Date: 2021/3/14
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Name <input type="txet" required><br/>
    Password<input type="password" required minlength="8"><br/>
    email <input type="email" required><br/>
    <input name="sex" type="radio" value="male">Male
    <input name="sex" type="radio" value="female">Female<br/>
    BirthDay <input type="date" required dataformatas="yyyy-dd-mm"><br/>
    <input type="submit" value="register">

</body>
</html>
