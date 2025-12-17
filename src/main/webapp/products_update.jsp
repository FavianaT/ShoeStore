<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product Page</title>
</head>
<body>
<h1>Product List</h1>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Color</th>
        <th>Size</th>
        <th>Price</th>
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

<hr/>

<h2>Update Existing Product</h2>

<form action="${pageContext.request.contextPath}/products.jsp" method="post">
    <input type="hidden" name="action" value ="update">

    <label>ID:
        <input type="number" name="id" required />
    </label><br/><br/>

    <label>Name:
        <input type="text" name="name"/>
    </label><br/><br/>

    <label>Description:
        <input type="text" name="description" />
    </label><br/><br/>

    <label>Color:
        <input type="text" name="color" />
    </label><br/><br/>

    <label>Size:
        <input type="number" name="size" step="0.5" />
    </label><br/><br/>

    <label>Price:
        <input type="number" name="price" step="0.01" />
    </label><br/><br/>

    <input type="submit" value="Update Product" />
</form>

<a href="products.jsp">Back to Create Product</a>

</body>
</html>
