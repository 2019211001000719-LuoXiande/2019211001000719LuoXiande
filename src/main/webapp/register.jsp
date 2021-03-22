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
<form method="post" action="register">
    Name <input type="txet"  name="username" required><br/>
    Password<input type="password" name="password" required minlength="8"><br/>
    email <input type="email" name="email" required><br/>
    <input name="gender" type="radio" value="male">Male
    <input name="gender" type="radio" value="female">Female<br/>
    BirthDay <input type="date" name="birthDate" required dataformatas="yyyy-dd-mm"><br/>
    <input type="submit" value="register">
</form>

</body>
</html>
