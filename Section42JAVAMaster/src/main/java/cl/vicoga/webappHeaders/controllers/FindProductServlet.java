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
import java.util.Optional;

@WebServlet("/find-product")
public class FindProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService service= new ProductServiceImpl();
        String productName= req.getParameter("productName");

        Optional<Product> product= service.findAll().stream()
                .filter(p->p.getName().equals(productName)).findFirst();
        if(product.isPresent()){

            resp.setContentType("text/html; charset=UTF-8");
            try(PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Product Found</title>");
                out.print("</head>");
                out.print("<body>");
                out.print("<h1>Product Found</h1>");

                out.print("<h3>Product: "+
                        product.get().getName()
                        +" the price is: "+product.get().getPrice()
                        +"</h3>");

                out.print("</body>");
                out.print("</html>");
            }

        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Product not found");
        }
    }





}
