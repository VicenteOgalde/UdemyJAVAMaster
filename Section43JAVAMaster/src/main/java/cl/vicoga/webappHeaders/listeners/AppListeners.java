package cl.vicoga.webappHeaders.listeners;

import cl.vicoga.webappHeaders.models.ShopCar;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class AppListeners implements ServletContextListener, ServletRequestListener
, HttpSessionListener {
    private ServletContext context;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Starting app");
        context= sce.getServletContext();
        context.setAttribute("message","global message!");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.log("Ending app");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        context.log("Ending request");
        sre.getServletRequest().setAttribute("message","some value for request");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        context.log("Starting request");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        context.log("Starting session");
        ShopCar car= new ShopCar();
        se.getSession().setAttribute("car",car);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        context.log("Ending session");
    }
}
