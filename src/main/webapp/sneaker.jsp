<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sneaker Product Page</title>
    <style>
        .product-image {
            width: 400px;
            height: auto;
        }
    </style>
</head>
<body>
<h1>Classic Sneakers</h1>

<img src="${pageContext.request.contextPath}/sneaker_image.jpg" alt="Classic Sneakers" class="product-image">
<p><strong>Description:</strong> A stylish and comfortable sneaker for everyday wear.</p>
<p><strong>Price per unit:</strong> $80.00</p>

<form action="${pageContext.request.contextPath}/calculateDiscount" method="POST">
    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" min="1" value="1" required>
    <br><br>
    <input type="submit" value="Order">
</form>


</body>
</html>
