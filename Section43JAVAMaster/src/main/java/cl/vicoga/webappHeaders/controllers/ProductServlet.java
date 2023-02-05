package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/products", "/products.html"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceJDBCImpl((Connection) req.getAttribute("conn"));
        List<Product> products = service.findAll();
        LoginService loginService= new LoginServiceSessionImpl();
        Optional<String> user= loginService.getUsername(req);

        req.setAttribute("products",products);
        req.setAttribute("user",user);

        getServletContext().getRequestDispatcher("/list-product.jsp").forward(req,resp);


    }
}
