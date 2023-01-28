package cl.vicoga.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get/param")
public class GetParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String greet= req.getParameter("greet");
        String name = req.getParameter("name");

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>Get Param</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Get Param</h1>");
        if(greet!=null && name!=null){
            out.print("<h2>"+greet+" "+name+"</h2>");
        } else if (greet!=null) {
            out.print("<h2>"+greet+"</h2>");
        }else {
            out.print("<h2>no greet for you</h2>");
        }

        out.print("</body>");
        out.print("</html>");
    }
}
