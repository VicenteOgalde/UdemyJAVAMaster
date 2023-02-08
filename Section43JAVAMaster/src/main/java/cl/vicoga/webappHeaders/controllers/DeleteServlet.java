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
import java.util.Optional;

@WebServlet("/products/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection  conn= (Connection) req.getAttribute("conn");
        ProductService service=new ProductServiceJDBCImpl(conn);
        Long id;
        try {
            id=Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException e){
            id=0l;
        }
        if (id >0) {
            Optional<Product> o=service.findById(id);
            if(o.isPresent()) {
                service.delete(id);
                resp.sendRedirect(req.getContextPath()+"/products");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Dont exist in the DB");
            }
        }else{
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Id null");
        }


    }
}
