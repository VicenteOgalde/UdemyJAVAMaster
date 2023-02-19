<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EJB Test</title>
</head>
<body>
<h1>Hello from EJB</h1>
<ul>
<c:forEach items="${products}" var="p">
    <li>${p.name}</li>
</c:forEach>
</ul>
<h3>${greet}</h3>
<h2>${greet2}</h2>

</body>
</html>