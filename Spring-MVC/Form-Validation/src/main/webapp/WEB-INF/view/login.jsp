<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Login</h2>
    <form:form action="login" modelAttribute="user" method="post" class="mt-4">
        <div class="form-group">
            <form:label path="email">Email</form:label>
            <form:input path="email" cssClass="form-control"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <form:label path="password">Password</form:label>
            <form:password path="password" cssClass="form-control"/>
            <form:errors path="password" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
        <div>
            <a href="register">Don't have an account? Register</a>
        </div>
    </form:form>
</div>
</body>
</html>
