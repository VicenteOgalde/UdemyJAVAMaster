package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.service.ProductService;
import cl.vicoga.webappHeaders.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products.json")
public class ProductJsonServlet extends HttpServlet {

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
