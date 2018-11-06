<%@include file="header.jsp" %>

<head>
    <title>Creating category</title>
</head>
<body>
<%@ include file="navBar.jsp"%>

<springForm:form class="form-signin" action="/admin/categories/create_category" method="post" modelAttribute="category">
    <h1 class="h3 mb-3 font-weight-normal">New category</h1>
    <springForm:label for="categoryName" class="sr-only" path="name">Category name</springForm:label>
    <springForm:input path="name" type="text" id="categoryName" class="form-control" placeholder="Category name"/>
    <springForm:button class="btn btn-lg btn-primary btn-block" type="submit">Save</springForm:button>
</springForm:form>

</body>
</html>
