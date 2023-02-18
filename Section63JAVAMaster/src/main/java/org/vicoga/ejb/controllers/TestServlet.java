package org.vicoga.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.vicoga.ejb.service.ServiceEjb;
import org.vicoga.ejb.service.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class TestServlet extends HttpServlet {
/*
    @EJB
    private ServiceEjb serviceEjb;
    @EJB
    private ServiceEjb serviceEjb2;*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEjbLocal serviceEjb=null;
        ServiceEjbLocal serviceEjb2=null;

        try {
            InitialContext ctx= new InitialContext();
            serviceEjb=(ServiceEjbLocal) ctx.lookup("java:global/Section63JAVAMaster/ServiceEjb!" +
                    "org.vicoga.ejb.service.ServiceEjb");
            serviceEjb2=(ServiceEjbLocal) ctx.lookup("java:global/Section63JAVAMaster/ServiceEjb!" +
                    "org.vicoga.ejb.service.ServiceEjb");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("2 service are equal: "+serviceEjb.equals(serviceEjb2));
        req.setAttribute("greet",serviceEjb.greet("mr X"));
        req.setAttribute("greet2",serviceEjb2.greet("mr Z"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
