package cl.vicoga.webappHeaders.filters;

import cl.vicoga.webappHeaders.service.ServiceJDBCException;
import cl.vicoga.webappHeaders.utils.ConnexionBDMysql;
import cl.vicoga.webappHeaders.utils.ConnexionBDMysqlDS;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConnexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try (Connection conn = ConnexionBDMysqlDS.getConnection()) {

            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                servletRequest.setAttribute("conn",conn);
                filterChain.doFilter(servletRequest, servletResponse);
                conn.commit();
            } catch (SQLException |ServiceJDBCException se) {
                conn.rollback();
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, se.getMessage());
                se.printStackTrace();
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
