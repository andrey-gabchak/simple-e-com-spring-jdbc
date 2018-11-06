<%@include file="header.jsp" %>

<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
        }
    </style>
</head>
<body>
<%@ include file="navBar.jsp"%>

<table style="align-items: center">
    <tr>
        <th>Category name</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td><form name="Edit category" action="/admin/categories/${category.id}" method="get">
                <button>Edit</button>
            </form>
            </td>
            <td>
                <form name="Delete category" action="/admin/categories/${category.id}_delete" method="post">
                    <button>Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form name="Create category" action="/admin/categories/create_category" method="get">
    <button>Create</button>
</form>
</div>

</body>
</html>
