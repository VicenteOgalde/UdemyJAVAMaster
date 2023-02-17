package org.vicoga.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.vicoga.ejb.service.ServiceEjb;

import java.io.IOException;

@WebServlet("/index")
public class TestServlet extends HttpServlet {

    @EJB
    private ServiceEjb serviceEjb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("greet",serviceEjb.greet("mr X"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
