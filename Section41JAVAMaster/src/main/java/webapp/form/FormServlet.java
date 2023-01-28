package webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass= req.getParameter("pass");
        String email= req.getParameter("email");


        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Form</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Form</h1>");
            out.print("<ul>");
            out.print("<li>"+user+"</li>");
            out.print("<li>"+pass+"</li>");
            out.print("<li>"+email+"</li>");
            out.print("</ul>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}
