package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.service.LoginService;
import cl.vicoga.webappHeaders.service.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USER="admin";
    final static String PASS="123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService= new LoginServiceImpl();
        Optional<String>cookie= loginService.getUsername(req);

        if(cookie.isPresent()){
            resp.setContentType("text/html; charset=UTF-8");
            try(PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Welcome "+cookie.get()+"</title>");
                out.print("</head>");
                out.print("<body>");
                out.print("<h1>Welcome "+cookie.get()+"</h1>");
                out.print("<p><a href=\""+req.getContextPath()+"/index.html\">Home</a></p>");
                out.print("<p><a href=\""+req.getContextPath()+"/logout\">Logout</a></p>");
                out.print("</body>");
                out.print("</html>");
            }
        }else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user= req.getParameter("user");
        String pass=req.getParameter("pass");

        if(USER.equals(user)&& PASS.equals(pass)){
            Cookie userCookie= new Cookie("user",user);
            resp.addCookie(userCookie);

            resp.sendRedirect(req.getContextPath()+"/login.html");
        }else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"not authorized");
        }


    }
}
