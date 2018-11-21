<%@include file="header.jsp" %>

<body>
<%@ include file="navBar.jsp" %>


<div class="container">
    <%--@elvariable id="product" type="com.gabchak.model.Product"--%>
    <springForm:form class="col-6" action="/buy" method="post" modelAttribute="product">
        <div class="row justify-content-end">
            <div class="col-6"><h1>${product.name} </h1></div>
        </div>
        <div class="row justify-content-end">
            <div class="col-6"><h3>${product.price} $</h3></div>
        </div>
        <div class="row justify-content-end">
            <p class="col-6"> id = ${product.id}</p>
        </div>
        <div class="row justify-content-center">
        </div>
        <div class="row justify-content-end">

            <springForm:button type="submit" class="btn btn-success">Buy</springForm:button>
        </div>
        <div class="row" style="margin-top: 50px">
            <p class="col-12">
                    ${product.description}
            </p>
        </springForm:form>
    </div>

</div>
</div>
</body>
</html>
