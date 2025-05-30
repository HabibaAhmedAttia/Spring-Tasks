<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>


</head>
<body>

    <h1>hello</h1>

    <form:form method="post" action="${pageContext.request.contextPath}/logout">
        <input type="submit" value="logout"/>
    </form:form>
</body>

</html>
