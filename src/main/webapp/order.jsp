<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Summary</title>
</head>
<body>
<h1>Order Summary</h1>

<p>Original Total Price: $${originalPrice}</p>
<p>Discount Applied: ${discountPercent}%</p>

<h3>Final Price (with discount): $${totalPrice}</h3>

<a href="${pageContext.request.contextPath}/sneaker.jsp">Place Another Order</a>
</body>
</html>
