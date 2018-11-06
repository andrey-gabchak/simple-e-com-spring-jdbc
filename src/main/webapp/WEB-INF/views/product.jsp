<%@include file="header.jsp" %>

<body>
<%@ include file="navBar.jsp" %>


<div class="container">
    <div class="row justify-content-end">
        <div class="col-6"><h1>${product.name} </h1></div>
    </div>
    <div class="row justify-content-end">
        <div class="col-6"><h3>${product.price}</h3></div>
    </div>
    <div class="row justify-content-end">
        <p class="col-6"> id = ${product.id}</p>
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
