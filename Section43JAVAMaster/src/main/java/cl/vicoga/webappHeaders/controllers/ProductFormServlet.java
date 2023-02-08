package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.service.ProductService;
import cl.vicoga.webappHeaders.service.ProductServiceJDBCImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@WebServlet("/products/form")
public class ProductFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn=(Connection)req.getAttribute("conn");
        ProductService service= new ProductServiceJDBCImpl(conn);
        Long id;
        try {
           id= Long.parseLong(req.getParameter("id"));

        }catch (NumberFormatException e){
            id=0l;
        }
        Product product= new Product();
        if(id>0){
           Optional<Product> op=service.findById(id);
            if(op.isPresent()){
                product=op.get();
            }
        }
        req.setAttribute("product",product);
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");
        ProductService service = new ProductServiceJDBCImpl(conn);

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        int price;
        try {
            price = Integer.parseInt(req.getParameter("price"));
        } catch (NumberFormatException e) {

            price = 0;
        }
        Map<String, String> errors = new HashMap<>();

        if (name == null || name.isBlank()) {
            errors.put("name", "name required");
        }
        if (type == null || type.isBlank()) {
            errors.put("type", "type required");
        }
        if (price == 0) {
            errors.put("price", "wrong price");
        }
        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0L;
        }
        Product product= new Product(id,name,type,price);
        if (errors.isEmpty()) {
            service.save(product);
            resp.sendRedirect(req.getContextPath() + "/products");
        } else {
            req.setAttribute("product",product);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);

        }
    }
}
