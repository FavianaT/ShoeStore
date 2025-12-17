package com.example;

import entity.Product;
import entity.ProductDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null || action.isBlank() || action.equals("read")) {
            // Show product list
            List<Product> products = productDAO.getAll();
            request.setAttribute("products", products);
            RequestDispatcher rd = request.getRequestDispatcher("/product_read.jsp");
            rd.forward(request, response);
            return;
        }

        if ("edit".equals(action)) {
            // Load single product and forward to update page (prefilled form)
            String idStr = request.getParameter("id");
            try {
                int id = Integer.parseInt(idStr);
                Optional<Product> opt = productDAO.get(id);
                Product product = (opt == null) ? null : opt.orElse(null);
                if (product != null) {
                    request.setAttribute("product", product);
                } else {
                    request.setAttribute("error", "Product with ID " + id + " not found.");
                }
            } catch (NumberFormatException ex) {
                request.setAttribute("error", "Invalid product id.");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/product_update.jsp");
            rd.forward(request, response);
            return;
        }

        // Unknown GET action -> redirect to list
        response.sendRedirect(request.getContextPath() + "/products?action=read");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) { 
            action = "";
        }

        switch (action) {
            case "create":
                handleCreate(request);
                break;
            case "update":
                handleUpdate(request);
                break;
            case "delete":
                handleDelete(request);
                break;
            default:
                handleCreate(request);
                break;
        }

        response.sendRedirect(request.getContextPath() + "/products?action=read");
    }

    private void handleCreate(HttpServletRequest request) {
        String Name = request.getParameter("Name");
        String Description = request.getParameter("Description");
        String Color = request.getParameter("Color");
        Double Size = Double.parseDouble(request.getParameter("Size"));
        Double Price = Double.parseDouble(request.getParameter("Price"));


        if (Name != null && Description != null && Color != null && Size > 0 && Price > 0
                && !Name.isBlank() && !Description.isBlank() && !Color.isBlank()) {

            Product p = new Product();
            p.setName(Name);
            p.setDescription(Description);
            p.setColor(Color);
            p.setSize(Size);
            p.setPrice(Price);
            productDAO.insert(p);
        }
    }

    private void handleUpdate(HttpServletRequest request) {
        String idStr = request.getParameter("ID");
        String Name = request.getParameter("Name");
        String Description = request.getParameter("Description");
        String Color = request.getParameter("Color");
        Double Size = Double.parseDouble(request.getParameter("Size"));
        Double Price = Double.parseDouble(request.getParameter("Price"));

        try {
            int id = Integer.parseInt(idStr);
            Product p = new Product();
            p.setName(Name);
            p.setDescription(Description);
            p.setColor(Color);
            p.setSize(Size);
            p.setPrice(Price);
            p.setID(id);
            productDAO.update(p);
        } catch (NumberFormatException ex) {
            System.err.println("Update parse error: " + ex.getMessage());
        }
    }

    private void handleDelete(HttpServletRequest request) {
        String idStr = request.getParameter("ID");
        try {
            int id = Integer.parseInt(idStr);
            Optional<Product> opt = productDAO.get(id);
            Product product = (opt == null) ? null : opt.orElse(null);
            if (product != null) {
                productDAO.delete(product);
            } else {
                System.err.println("Product to delete not found: " + id);
            }
        } catch (NumberFormatException ex) {
            System.err.println("Delete parse error: " + ex.getMessage());
        }
    }
}
