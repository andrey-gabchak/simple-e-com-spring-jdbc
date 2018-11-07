<%@include file="header.jsp" %>

<head>
    <style>
        .top-buffer {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<%@ include file="navBar.jsp" %>


<div class="container">

    <div class="row top-buffer">
        <div class="col-8"><h1 class="display-4">Products</h1></div>
    </div>
    <div class="row top-buffer">
        <div class="col-1"><b>Id</b></div>
        <div class="col-6"><b>Name</b></div>
        <div class="col-2"><b>Price</b></div>
        <div class="col-1"><b>Cat Id</b></div>
    </div>
    <c:forEach items="${products}" var="product">
        <div class="row top-buffer">

            <div class="col-1">${product.id}</div>
            <div class="col-6">${product.name}</div>
            <div class="col-2">${product.price}</div>
            <div class="col-1">${product.categoryId}</div>

            <div class="col-1">
                <div class="col-md-12">
                    <form name="Edit product" action="/admin/products/edit_${product.id}" method="get">
                        <button type="submit" class="btn btn-default">Edit</button>
                    </form>
                </div>
            </div>

            <div class="col-1">
                <div class="col-md-12">
                    <form name="Delete product" action="/admin/products/delete_${product.id}" method="post">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>

        </div>
    </c:forEach>
    <div class="row top-buffer">
        <div class="col-md-10 text-center">
            <form name="Create product" action="/admin/products/create_product" method="get">
                <button type="submit" class="btn btn-primary btn-lg">Create</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>