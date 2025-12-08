package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;

@WebServlet("/calculateDiscount")
public class DiscountServlet extends HttpServlet {
    private static final double UNIT_PRICE = 80.00;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int quantity = 0;
        try {
            // Get quantity from the form
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
            // Handle invalid input
            response.sendRedirect("order.jsp?error=invalidQuantity");
            return;
        }

        double originalPrice = UNIT_PRICE * quantity;
        double discountPercent = 0.0;
        double totalPrice = originalPrice;

        // Apply discount logic
        if (quantity >= 10) {
            discountPercent = 10.0;
            totalPrice = originalPrice * 0.90; // 10% discount
        } else if (quantity >= 5) {
            discountPercent = 5.0;
            totalPrice = originalPrice * 0.95; // 5% discount
        }
        // No discount otherwise

        // Set attributes to be accessed in the JSP
        request.setAttribute("originalPrice", df.format(originalPrice));
        request.setAttribute("discountPercent", df.format(discountPercent));
        request.setAttribute("totalPrice", df.format(totalPrice));

        // Forward back to the order page to display results
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }
}
