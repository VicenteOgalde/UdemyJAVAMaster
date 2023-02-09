package cl.vicoga.webappHeaders.controllers;

import cl.vicoga.webappHeaders.models.User;
import cl.vicoga.webappHeaders.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Optional;

@WebServlet({"/login","/login.html"})
public class LoginServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService= new LoginServiceSessionImpl();
        Optional<String>username= loginService.getUsername(req);

        if(username.isPresent()){
            resp.setContentType("text/html; charset=UTF-8");
            try(PrintWriter out = resp.getWriter()) {
                out.print("<!DOCTYPE html>");
                out.print("<html>");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<title>Welcome "+username.get()+"</title>");
                out.print("</head>");
                out.print("<body>");
                out.print("<h1>Welcome "+username.get()+"</h1>");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String user= req.getParameter("user");
        String pass=req.getParameter("pass");

        UserService service= new UserServiceImpl((Connection)req.getAttribute("conn"));
        Optional<User> opUser= service.login(user,pass);
        if(opUser.isPresent()){
            HttpSession session= req.getSession();
            session.setAttribute("user",user);

            //Cookie userCookie= new Cookie("user",user);
            //resp.addCookie(userCookie);

            resp.sendRedirect(req.getContextPath()+"/login.html");
        }else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"not authorized");
        }


    }
}
