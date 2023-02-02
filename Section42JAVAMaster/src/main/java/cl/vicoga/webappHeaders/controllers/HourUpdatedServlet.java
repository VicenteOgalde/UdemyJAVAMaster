package cl.vicoga.webappHeaders.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/hour")
public class HourUpdatedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("refresh","1");
        LocalTime hour= LocalTime.now();
        DateTimeFormatter df= DateTimeFormatter.ofPattern("hh:mm:ss");

        try(PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Hour now</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Hour now</h1>");
            out.print("<h3>"+hour.format(df)+"</h3>");
            out.print("</body>");
            out.print("</html>");
        }

    }
}
