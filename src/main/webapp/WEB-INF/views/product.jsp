<%@include file="header.jsp" %>

<body>
<%@ include file="navBar.jsp"%>

<div>
    <h1>${product.name} </h1>
    <div>
        id = ${product.id}
    </div>
    <div>
        <h3>${product.price}</h3>
    </div>
    <div>
        <p>
            ${product.description}
        </p>
    </div>
</div>
</body>
</html>
