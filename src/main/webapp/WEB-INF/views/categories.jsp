<%@include file="header.jsp" %>
<head>
    <title>All categories</title>
</head>
<body>
<%@ include file="navBar.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-12 text-center">
            <h1 class="display-4">Categories</h1>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-6 list-group text-center">
            <c:forEach var="c" items="${categories}">
                <a href="<c:url value = "/${c.categoryName}"/>" class="list-group-item list-group-item-action"><c:out
                        value="${c.categoryName}"/></a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>