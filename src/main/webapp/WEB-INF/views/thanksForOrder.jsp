<%@include file="header.jsp" %>
<head>
    <title>All categories</title>
</head>
<body>
<%@ include file="navBar.jsp"%>
<div class="container">
    <div class="row">
        <h1 class="col-12 text-center display-4">Thank you for your purchase</h1>
    </div>
    <div class="row">
        <p class="col-12 text-center"><b>Your order number is ${order.orderId}</b></p>
    </div>
    <div class="row">
        <a href="/home" class="col-12 text-center">go home</a>
    </div>
</div>

</body>
</html>
