package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.service.ProductService;
import cl.vicoga.webappHeaders.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/products", "/products.html"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImpl();
        List<Product> products = service.findAll();

        resp.setContentType("text/html; charset=UTF-8");


        try (PrintWriter out = resp.getWriter()) {

            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Product List</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Product List</h1>");
            out.print("<table>");
            out.print("<tr>");
            out.print("<th>Id</th>");
            out.print("<th>Name</th>");
            out.print("<th>Type</th>");
            out.print("<th>Price</th>");
            out.print("</tr>");
            products.forEach(p -> {
                out.print("<tr>");
                out.print("<td>" + p.getId() + "</td>");
                out.print("<td>" + p.getName() + "</td>");
                out.print("<td>" + p.getType() + "</td>");
                out.print("<td>" + p.getPrice() + "</td>");
                out.print("</tr>");
            });


            out.print("</table>");

            out.print("</body>");
            out.print("</html>");

        }
    }
}