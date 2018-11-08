<%@include file="header.jsp" %>

<head>
    <title>Edit ${category.name}</title>
</head>
<body>
<%@ include file="navBar.jsp" %>
<div class="container">
    <springForm:form class="form-group" action="/admin/products/save_${product.id}" method="post" modelAttribute="product">
        <div class="row justify-content-center">
            <h1 class="h3 mb-3 font-weight-normal">Edit ${product.name}</h1>
        </div>
        <div class="row" style="margin-bottom: 20px">
            <div class="col-4">
                <springForm:label for="productName" class="sr-only" path="name">Category name</springForm:label>
                <springForm:input path="name" type="text" id="productName" class="form-control" placeholder="Product name"/>
            </div>
            <div class="col-2">
                <springForm:label for="productPrice" class="sr-only" path="price">Category name</springForm:label>
                <springForm:input path="price" type="text" id="productPrice" class="form-control" placeholder="Product price"/>
            </div>
            <div class="col-5">
                <springForm:label for="productDescription" class="sr-only" path="description">Category name</springForm:label>
                <springForm:input path="description" type="text" id="productDescription" class="form-control" placeholder="Product description"/>
            </div>
            <div class="col-1">
                <springForm:label for="categoryId" class="sr-only" path="categoryId">Category name</springForm:label>
                <springForm:input path="categoryId" type="text" id="categoryId" class="form-control" placeholder="Cat Id"/>
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
