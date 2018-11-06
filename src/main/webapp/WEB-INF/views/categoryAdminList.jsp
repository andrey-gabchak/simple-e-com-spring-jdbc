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
        <div class="col-8"><h1>Categories</h1></div>
    </div>
    <c:forEach items="${categories}" var="category">
        <div class="row top-buffer">
            <div class="col-8">${category.name}</div>
            <div class="col-1">
                <div class="col-md-12">
                    <form name="Edit category" action="/admin/categories/${category.id}" method="get">
                        <button type="button" class="btn btn-default">Edit</button>
                    </form>
                </div>
            </div>
            <div class="col-1">
                <div class="col-md-12">
                    <form name="Delete category" action="/admin/categories/${category.id}_delete" method="post">
                        <button type="button" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
    <div class="row top-buffer">
        <div class="col-md-10 text-center">
            <form name="Create category" action="/admin/categories/create_category" method="get">
                <button type="button" class="btn btn-primary btn-lg">Create</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
