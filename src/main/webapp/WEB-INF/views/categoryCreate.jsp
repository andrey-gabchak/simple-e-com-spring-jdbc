<%@include file="header.jsp" %>

<head>
    <title>Creating category</title>
</head>
<body>
<%@ include file="navBar.jsp"%>
<div class="container">
    <springForm:form class="form-group" action="/admin/categories/create_category" method="post" modelAttribute="category">
        <div class="row justify-content-center">
            <h1 class="h3 mb-3 font-weight-normal">New category</h1>
        </div>
        <div class="row justify-content-center" style="margin-bottom: 20px">
            <div class="col-6">
                <springForm:label for="categoryName" class="sr-only" path="name">Category name</springForm:label>
                <springForm:input path="name" type="text" id="categoryName" class="form-control" placeholder="Category name"/>

            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <springForm:button class="btn btn-lg btn-primary" type="submit">Save</springForm:button>
            </div>
        </div>
    </springForm:form>
</div>
</body>
</html>
