package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.ItemCar;
import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.models.ShopCar;
import cl.vicoga.webappHeaders.service.ProductService;
import cl.vicoga.webappHeaders.service.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/add-car")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("id"));

        ProductService service = new ProductServiceImpl();
        Optional<Product> opProduct= service.findById(id);
        if(opProduct.isPresent()){
            ItemCar itemCar= new ItemCar(1,opProduct.get());
            HttpSession session = req.getSession();
            ShopCar car;
            if(session.getAttribute("car")==null){
                car=new ShopCar();
                session.setAttribute("car",car);
            }else {
                car=(ShopCar) session.getAttribute("car");
            }
            car.addItem(itemCar);
        }
        resp.sendRedirect(req.getContextPath()+"/show-car");

    }
}
