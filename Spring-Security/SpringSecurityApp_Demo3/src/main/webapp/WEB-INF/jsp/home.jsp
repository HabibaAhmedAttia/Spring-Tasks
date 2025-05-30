<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

    <h1>hello</h1>
    <security:authentication property="principal.username"/>

    <p>
        you logged in as : <security:authentication property="principal.authorities"/>
    </p>

    <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/systems/systemParent" class="btn btn-info">System Page</a>
        <p>this part is only for admins "this app developed by ahmed salah"</p>
    </security:authorize>

    <form:form method="post" action="${pageContext.request.contextPath}/logout">
        <input type="submit" value="logout" class="btn btn-danger"/>
    </form:form>
</body>

</html>
