package cl.vicoga.webappHeaders.filters;

import cl.vicoga.webappHeaders.service.LoginService;
import cl.vicoga.webappHeaders.service.LoginServiceSessionImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/car/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LoginService loginService= new LoginServiceSessionImpl();
        Optional<String>username= loginService.getUsername((HttpServletRequest) servletRequest);

        if(username.isPresent()){
            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Not authorized");
        }
    }
}
