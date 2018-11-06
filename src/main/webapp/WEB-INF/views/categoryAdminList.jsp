<%@include file="header.jsp" %>

<table style="align-items: center">
    <tr>
        <th>Category name</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name} <input type="button" href="/admin/categories/${category.id}" value="edit"/> <input type="button" formmethod="post" href="/admin/categories/${category.id}_delete"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<button href="/admin/categories/create_category" value="Create category">Create</button>

</body>
</html>
