<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>

</head>
<body>

<c:forEach var="cat" items="${categories}">
    <a href="<c:url value = "/?cat_id=${cat.id}"/>" class="list-group-item list-group-item-action">
        <c:out value="${cat.name}"/></a>
</c:forEach>
</body>
</html>
