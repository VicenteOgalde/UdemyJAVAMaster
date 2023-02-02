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
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        Optional<String> user=loginService.getUsername(req);
        if(user.isPresent()){
            Cookie cookie= new Cookie("user","");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);

        }
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}
