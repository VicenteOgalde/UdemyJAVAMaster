package cl.vicoga.webappHeaders.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    final static String USER="admin";
    final static String PASS="123";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user= req.getParameter("user");
        String pass=req.getParameter("pass");

        if(USER.equals(user)&& PASS.equals(pass)){

            resp.setContentType("text/html; charset=UTF-8");
            try(PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Login OK</title>");
                out.print("</head>");
                out.print("<body>");
                out.print("<h1>Login OK</h1>");
                out.print("<h3>Hello "+user+"</h3>");
                out.print("</body>");
                out.print("</html>");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"not authorized");
        }


    }
}
