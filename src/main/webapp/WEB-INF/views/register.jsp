<%@include file="header.jsp" %>
<head>
    <title>Register new user</title>
</head>
<body class="text-center">
<springForm:form class="form-signin" action="/register" method="post" modelAttribute="userDto">
    <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>

    <label for="inputEmail" class="sr-only">Email address</label>
    <springForm:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"/>

    <label for="inputPassword" class="sr-only">Password</label>
    <springForm:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"/>

    <label for="inputPassword" class="sr-only">Repeat password</label>
    <springForm:input path="verifiedPassword" type="password" id="inputPassword" class="form-control" placeholder="Password"/>

    <springForm:errors path="verifiedPassword" cssClass="error"/>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>

    <br>
    <a class="btn btn-link" href="/login">back to login</a>
</springForm:form>
</body>
</html>