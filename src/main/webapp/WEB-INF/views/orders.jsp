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
        <div class="col-8"><h1 class="display-4">Categories</h1></div>
    </div>
    <c:forEach items="${orders}" var="order">
        <div class="row top-buffer">
            <div class="col-1">${order.orderId}</div>
            <div class="col-3">${order.customer.name}</div>
            <div class="col-1">${order.amount}</div>
            <div class="col-2">${order.date}</div>
            <div class="col-3">${order.orderComment}</div>
            <div class="col-1">
                <div class="col-md-12">
                    <form name="Edit order" action="/admin/orders/edit_${order.orderId}" method="get">
                        <button type="submit" class="btn btn-default">Edit</button>
                    </form>
                </div>
            </div>
            <div class="col-1">
                <div class="col-md-12">
                    <form name="Delete order" action="/admin/orders/delete_${order.orderId}_delete" method="post">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
    <div class="row top-buffer">
        <div class="col-md-10 text-center">
            <form name="Create category" action="/admin/orders/create_order" method="get">
                <button type="submit" class="btn btn-primary btn-lg">Create</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
