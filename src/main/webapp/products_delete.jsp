<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>

<form action="${pageContext.request.contextPath}/products.jsp" method="post">
    <input type="hidden" name="action" value="delete" />

    <label>Product ID to delete:
        <input type="text" name="ID" required />
    </label><br/><br/>

    <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete product ID: ' + this.form.ID.value + '?');" />
</form>

<a href="products.jsp">Back to Create Product</a>

</body>
</html>