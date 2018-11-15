<%@ taglib prefix="springform" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<head>
    <title>Cart</title>
</head>
<body>
<%@ include file="navBar.jsp"%>

<div class="container">
    <springForm:form action="/cart/confirm" cssClass="form-group" method="post" modelAttribute="order">
        <div class="row">
            <div class="col-10">
                <h4>Products</h4>
            </div>
            <div class="col-1">
                <h4>Quantity</h4>
            </div>
            <div class="col-1">
                <h4>Price</h4>
            </div>
        </div>
        <springform:forEach items="${order.products}" var="product">
            <div class="row">
                <div class="col-10">${product.name}</div>
                <div class="col-1">${order.productsQuantity['product.id']}
                </div>
                <div class="col-1">${product.price}</div>
            </div>
        </springform:forEach>
        <div class="row text-lg-right">
            <p class="col-1"><b>${order.orderAmount}</b></p>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <springForm:button class="btn btn-lg btn-primary" type="submit">Confirm order</springForm:button>
            </div>
        </div>
    <springForm:form/>
</div>

</body>
</html>
