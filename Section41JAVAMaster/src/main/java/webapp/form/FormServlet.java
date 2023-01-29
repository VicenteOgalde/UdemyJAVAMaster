package webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/register")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass= req.getParameter("pass");
        String email= req.getParameter("email");
        String country= req.getParameter("country");
        String [] languages= req.getParameterValues("language");
        String[] roles= req.getParameterValues("roles");
        String lang= req.getParameter("lang");
        String secret= req.getParameter("secret");
        String enable= req.getParameter("enable");

        Map<String,String> errors= new HashMap<>();

        if(user==null||user.isBlank()){
            errors.put("user","user required");
        }
        if(pass==null||pass.isBlank()){
            errors.put("pass","pass required");
        }
        if(email==null||!email.contains("@")){
            errors.put("email","email wrong");
        }
        if(country==null||country.isBlank()){
            errors.put("country","country required");
        }
        if(languages==null||languages.length==0){
            errors.put("language","select a language please");
        }
        if(roles==null||roles.length==0){
            errors.put("role","select a role please");
        }
        if(lang==null){
            errors.put("lang","language required");
        }


        resp.setContentType("text/html");
            if(errors.isEmpty()) {
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


                out.print("<li>User: " + user + "</li>");
                out.print("<li>Pass: " + pass + "</li>");
                out.print("<li>Email: " + email + "</li>");
                out.print("<li>Country: " + country + "</li>");
                out.print("<li>Languages: <ul>");
                Arrays.asList(languages).forEach(l -> out.print("<li>     " + l + "</li>"));
                out.print("</ul></li>");
                out.print("<li>Roles: <ul>");
                Arrays.asList(roles).forEach(r -> out.print("<li>     " + r + "</li>"));
                out.print("<li>Lang: " + lang + "</li>");
                out.print("<li>Enabled: " + enable + "</li>");
                out.print("<li>Secret: " + secret + "</li>");
                out.print("</ul></li>");

            out.print("</ul>");
            out.print("</body>");
            out.print("</html>");
        }
            }else{
                /*
                errors.forEach(e->out.print("<li>"+e+"</li>"));
                out.print("<p><a href=\"/Section41JAVAMaster\">Home</a></p>");
            */
                req.setAttribute("errors",errors);
                getServletContext().getRequestDispatcher("/index.jsp")
                        .forward(req,resp);
            }
    }
}
