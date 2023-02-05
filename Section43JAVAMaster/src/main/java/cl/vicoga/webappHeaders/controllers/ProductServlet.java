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
import java.util.List;
import java.util.Optional;

@WebServlet({"/products", "/products.html"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service = new ProductServiceImpl();
        List<Product> products = service.findAll();
        LoginService loginService= new LoginServiceSessionImpl();
        Optional<String> user= loginService.getUsername(req);
        resp.setContentType("text/html; charset=UTF-8");

        String  messageRequest=(String) req.getAttribute("message");
        String messageGlobal=(String) getServletContext().getAttribute("message");

        try (PrintWriter out = resp.getWriter()) {

            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Product List</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Product List</h1>");
            user.ifPresent(s -> out.print("<h4>complete data for " + s + "</h4>"));
            out.print("<table>");
            out.print("<tr>");
            out.print("<th>Id</th>");
            out.print("<th>Name</th>");
            out.print("<th>Type</th>");
            if(user.isPresent()) {
            out.print("<th>Price</th>");
             out.print("<th>Add</th>");
        }
            out.print("</tr>");
            products.forEach(p -> {
                out.print("<tr>");
                out.print("<td>" + p.getId() + "</td>");
                out.print("<td>" + p.getName() + "</td>");
                out.print("<td>" + p.getType() + "</td>");
                if(user.isPresent()) {
                    out.print("<td>" + p.getPrice() + "</td>");
                    out.print("<td><a href=\""+req.getContextPath()+"/add-car?id="+p.getId()
                            +"\">Add Product</a></td>");
                }
                out.print("</tr>");
            });


            out.print("</table>");
            out.print("<p>Global: "+messageGlobal+"</p>");
            out.print("<p>Request: "+messageRequest+"</p>");
            out.print("<p><a href=\""+req.getContextPath()+"/index.html\">Home</a></p>");
            if(user.isPresent()) {
                out.print("<p><a href=\"" + req.getContextPath() + "/logout\">Logout</a></p>");
            }
            out.print("</body>");
            out.print("</html>");

        }
    }
}
