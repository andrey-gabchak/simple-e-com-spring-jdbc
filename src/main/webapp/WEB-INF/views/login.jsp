<%@include file="header.jsp" %>

<body class="text-center">
<springForm:form class="form-signin" action="/login" method="post" modelAttribute="user">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <springForm:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"/>
    <label for="inputPassword" class="sr-only">Password</label>
    <springForm:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</springForm:form>

</body>
</html>