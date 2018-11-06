<%@include file="header.jsp" %>

<springForm:form class="form-signin" action="/admin/categories/create_category" method="post" modelAttribute="category">
    <h1 class="h3 mb-3 font-weight-normal">New category</h1>
    <label for="categoryName" class="sr-only">Category name</label>
    <springForm:input path="name" type="text" id="categoryName" class="form-control" placeholder="Category name"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
</springForm:form>

</body>
</html>
