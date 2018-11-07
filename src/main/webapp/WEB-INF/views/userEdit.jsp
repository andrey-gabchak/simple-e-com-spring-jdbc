<%@include file="header.jsp" %>

<head>
    <title>Edit ${user.firstName} ${user.id}</title>
</head>
<body>
<%@ include file="navBar.jsp" %>
<div class="container">
    <springForm:form class="form-group" action="/admin/users/save_${user.id}" method="post" modelAttribute="user">
        <div class="row justify-content-center">
            <h1 class="h3 mb-3 font-weight-normal">Edit ${user.firstName}</h1>
        </div>
        <div class="row" style="margin-bottom: 20px">
            <div class="col-4">
                <springForm:label for="userEmail" class="sr-only" path="email">User email</springForm:label>
                <springForm:input path="email" type="email" id="userEmail" class="form-control" placeholder="${user.email}"/>
            </div>
            <div class="col-4">
                <springForm:label for="userFirstName" class="sr-only" path="firstName">Category name</springForm:label>
                <springForm:input path="firstName" type="text" id="userFirstName" class="form-control" placeholder="${user.firstName}"/>
            </div>
            <div class="col-4">
                <springForm:label for="userLastName" class="sr-only" path="lastName">Category name</springForm:label>
                <springForm:input path="lastName" type="text" id="userLastName" class="form-control" placeholder="#{user.lastName}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <springForm:button class="btn btn-lg btn-primary" type="submit">Save</springForm:button>
            </div>
        </div>
    </springForm:form>
</div>
</body>
</html>
