package cl.vicoga.webappHeaders.listeners;

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

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.log("Ending app");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        context.log("Ending request");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        context.log("Starting request");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        context.log("Starting session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        context.log("Ending session");
    }
}
