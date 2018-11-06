<%@include file="header.jsp" %>

<body>
<%@ include file="navBar.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-8"><h1>${product.name} </h1></div>
        <div class="col-4"><h3>${product.price}</h3></div>
    </div>
    <div class="rom">
        <p class="col-1"> id = ${product.id}</p>
    </div>
    <div class="row">
        <p class="col-12">
            ${product.description}
        </p>
    </div>

</div>
</div>
</body>
</html>
