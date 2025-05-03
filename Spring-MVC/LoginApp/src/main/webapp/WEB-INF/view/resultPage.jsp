<html>
<head>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body >
    <h1>Hello to Student App</h1>
    <h3>username is : ${userModelResult.userName} </h3>
    <h3>password is : ${userModelResult.password} </h3>
    <h3>password is : ${userModelResult.country} </h3>
    <h3>password is : ${userModelResult.programmingLanguage} </h3>
    <h3>first prog lang is : ${userModelResult.operatingSystem} </h3>
<%--    <h3>second prog lang is : ${userModelResult.operatingSystem[1]} </h3>--%>

</body>
</html>


