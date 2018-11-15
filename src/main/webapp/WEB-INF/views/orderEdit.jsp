<%@include file="header.jsp" %>

<head>
    <title>Edit ${order.name}</title>
</head>
<body>
<%@ include file="navBar.jsp" %>
<div class="container">
    <springForm:form class="form-group" action="/admin/orders/save_${order.id}" method="post" modelAttribute="order">
        <div class="row justify-content-center">
            <h1 class="h3 mb-3 font-weight-normal">Edit ${order.orderId}</h1>
        </div>
        <div class="row col-12">
            <div class="row" style="margin-bottom: 20px">
                <div class="col-4">
                    <springForm:label for="customerId" class="sr-only"
                                      path="customerId">Category name</springForm:label>
                    <springForm:input path="customerId" type="text" id="customerId" class="form-control"
                                      placeholder="${order.customerId}"/>
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px">
                <div class="col-4">
                    <springForm:label for="orderDate" class="sr-only" path="orderDate">Category name</springForm:label>
                    <springForm:input path="orderDate" type="text" id="orderDate" class="form-control"
                                      placeholder="${order.orderDate}"/>
                </div>
            </div>
            <div class="row" style="margin-bottom: 20px">
                <div class="col-4">
                    <springForm:label for="orderAmount" class="sr-only"
                                      path="orderAmount">Category name</springForm:label>
                    <springForm:input path="orderAmount" type="text" id="orderAmount" class="form-control"
                                      placeholder="${order.orderAmount}"/>
                </div>
            </div>
            <div class="row justify-content-center" style="margin-bottom: 20px">
                <div class="col-4">
                    <springForm:label for="orderComment" class="sr-only"
                                      path="orderComment">Category name</springForm:label>
                    <springForm:input path="orderComment" type="text" id="orderComment" class="form-control"
                                      placeholder="${order.orderComment}"/>
                </div>
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
