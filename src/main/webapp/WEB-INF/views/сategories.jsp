<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Categories</title>
</head>
<body>


<div class="container form-signin">
    <h1 class="display-4">Categories</h1>

    <div class="list-group">
<%--TODO: output category list--%>
        <c:forEach var="c" items="${categories}">
            <a href="<c:url value = "/servlet/category?c_id=${c.id}"/>" class="list-group-item list-group-item-action"><c:out
                    value="${c.name}"/></a>
        </c:forEach>

    </div>
</div>
</body>
</html>
