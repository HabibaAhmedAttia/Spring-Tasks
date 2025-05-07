<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Register</h2>
    <form:form action="register" modelAttribute="user" method="post" class="mt-4">
        <div class="form-group">
            <form:label path="name">Name</form:label>
            <form:input path="name" cssClass="form-control"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>

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
            <form:label path="confirmPassword">Confirm Password</form:label>
            <form:password path="confirmPassword" cssClass="form-control"/>
            <form:errors path="confirmPassword" cssClass="text-danger"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success">Register</button>
        </div>
        <div>
            <a href="login.jsp">Already have an account? Login</a>
        </div>
    </form:form>
</div>
</body>
</html>
