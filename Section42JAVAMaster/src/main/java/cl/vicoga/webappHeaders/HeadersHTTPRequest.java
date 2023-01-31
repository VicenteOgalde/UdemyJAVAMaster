package cl.vicoga.webappHeaders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/headers-request")
public class HeadersHTTPRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String methodHTTP=req.getMethod();
        String requestUri=req.getRequestURI();
        String requestURL= req.getRequestURL().toString();

        String ip = req.getLocalAddr();
        int port= req.getLocalPort();
        String scheme= req.getScheme();

        try(PrintWriter out = resp.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\">");
            out.print("<title>Headers HTTP Request</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Headers HTTP Request</h1>");
            out.print("<ul>");
            out.print("<li>Method HTTP: "+methodHTTP+"</li>");
            out.print("<li>URI: "+requestUri+"</li>");
            out.print("<li>URL: "+requestURL+"</li>");
            out.print("<li>ip: "+ip+"</li>");
            out.print("<li>port: "+port+"</li>");
            out.print("<li>scheme: "+scheme+"</li>");
            out.print("</ul>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}
