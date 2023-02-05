package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.ShopCar;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/update-car")
public class UpdateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("car") != null) {
            ShopCar car = (ShopCar) session.getAttribute("car");
            updateProducts(req, car);
            updateAmounts(req, car);
        }

        resp.sendRedirect(req.getContextPath() + "/show-car");
    }

    private void updateProducts(HttpServletRequest request, ShopCar car) {
        String[] deleteIds = request.getParameterValues("deleteProducts");

        if (deleteIds != null && deleteIds.length > 0) {
            List<String> productIds = Arrays.asList(deleteIds);

            car.removeProducts(productIds);
        }

    }

    private void updateAmounts(HttpServletRequest request, ShopCar car) {

        Enumeration<String> enumer = request.getParameterNames();


        while (enumer.hasMoreElements()) {
            String paramName = enumer.nextElement();
            if (paramName.startsWith("amount_")) {
                String id = paramName.substring(7);
                String amount = request.getParameter(paramName);
                if (amount != null) {
                    car.updateAmount(id, Integer.parseInt(amount));
                }
            }
        }
    }
}
