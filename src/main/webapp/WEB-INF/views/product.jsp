<%@include file="header.jsp" %>

<body>
<%@ include file="navBar.jsp" %>


<div class="container">
    <div class="row justify-content-end">
        <div class="col-6"><h1>${product.name} </h1></div>
    </div>
    <div class="row justify-content-end">
        <div class="col-6"><h3>${product.price} $</h3></div>
    </div>
    <div class="row justify-content-end">
        <p class="col-6"> id = ${product.id}</p>
    </div>
    <div class="row justify-content-end">
        <form class="col-6" action="#">
            <button type="button" class="btn btn-success">Buy</button>
        </form>
    </div>
    <div class="row" style="margin-top: 50px">
        <p class="col-12">
            ${product.description}
        </p>
    </div>

</div>
</div>
</body>
</html>
