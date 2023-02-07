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


@WebServlet("/products/form")
public class ProductFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn=(Connection) req.getAttribute("conn");
        ProductService service= new ProductServiceJDBCImpl(conn);
        int price;
        try{
            price=Integer.parseInt(req.getParameter("price"));
        }catch (NumberFormatException e){
            price=0;
        }
        service.save(
                new Product(null,
                        req.getParameter("name"),
                        req.getParameter("type"),
                        price)
        );
        resp.sendRedirect(req.getContextPath()+"/products");

    }
}
