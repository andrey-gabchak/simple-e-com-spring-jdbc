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
        <div class="col-8"><h1 class="display-4">Users</h1></div>
    </div>
    <div class="row top-buffer">
        <div class="col-3"><b>First Name</b></div>
        <div class="col-3"><b>Last Name</b></div>
        <div class="col-4"><b>Email</b></div>
    </div>
    <c:forEach items="${users}" var="user">
        <div class="row top-buffer">

            <div class="col-3">${uset.firstName}</div>
            <div class="col-3">${user.lastName}</div>
            <div class="col-4">${user.email}</div>

            <div class="col-1">
                <div class="col-md-12">
                    <form name="Edit product" action="/admin/users/edit_${user.id}" method="get">
                        <button type="submit" class="btn btn-default">Edit</button>
                    </form>
                </div>
            </div>

            <div class="col-1">
                <div class="col-md-12">
                    <form name="Delete product" action="/admin/users/delete_${user.id}" method="post">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>

        </div>
    </c:forEach>

</div>

</body>
</html>