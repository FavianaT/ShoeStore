<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Read Products</title>
</head>
<body>
<h1>Products</h1>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Color</th>
        <th>Size</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="prod" items="${products}">
        <tr>
            <td>${prod.ID}</td>
            <td>${prod.name}</td>
            <td>${prod.description}</td>
            <td>${prod.color}</td>
            <td>${prod.size}</td>
            <td>${prod.price}</td>

        </tr>
    </c:forEach>
</table>

<a href="products.jsp">Back to Create Product</a>

</body>
</html>