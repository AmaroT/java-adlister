<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")){
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<html>
<head>
    <title>Login Form</title>
    <%@include file="partials/css.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp" %>
<input type="submit">
<form Method="POST" action= ${pageContext.request.contextPath}/login.jsp>
    <label for="username">Username</label>
    <input id="username" name="username" type="text">
    <br>
    <label for="password">Password</label>
    <input id="password" name="password" type="password">
    <br>
    <input type="submit">
</form>
<%@include file="partials/javascript.jsp" %>

</body>
</html>