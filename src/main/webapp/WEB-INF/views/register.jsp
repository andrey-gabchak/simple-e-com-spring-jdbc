<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Register</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/static/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/css/singin.css"/>" rel="stylesheet">
</head>
<body class="text-center">
<spring:form class="form-signin" action="/register" method="post" modelAttribute="userDto">
    <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>

    <label for="inputEmail" class="sr-only">Email address</label>
    <spring:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address"/>

    <label for="inputPassword" class="sr-only">Password</label>
    <spring:input path="password" type="password" id="inputPassword" class="form-control" placeholder="Password"/>

    <label for="inputPassword" class="sr-only">Repeat password</label>
    <spring:input path="verifiedPassword" type="password" id="inputPassword" class="form-control" placeholder="Password"/>

    <spring:errors path="verifiedPassword" cssClass="error"/>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
</spring:form>
</body>
</html>