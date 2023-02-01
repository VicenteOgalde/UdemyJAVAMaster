package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.service.ProductService;
import cl.vicoga.webappHeaders.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products.json")
public class ProductJsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream jsonStream= req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Product product=mapper.readValue(jsonStream,Product.class);

        resp.setContentType("text/html; charset=UTF-8");
        try(PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Product Json</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Product Json</h1>");
            out.print("<ul>");
            out.print("<li>Id: "+product.getId()+"</li>");
            out.print("<li>Name: "+product.getName()+"</li>");
            out.print("<li>Type: "+product.getType()+"</li>");
            out.print("<li>Price: "+product.getPrice()+"</li>");
            out.print("</ul>");
            out.print("</body>");
            out.print("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service= new ProductServiceImpl();
        List<Product> products=service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json=mapper.writeValueAsString(products);

        resp.setContentType("application/json");
        resp.getWriter().write(json);





    }
}
