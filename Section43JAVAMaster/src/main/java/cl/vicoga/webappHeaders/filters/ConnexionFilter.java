package cl.vicoga.webappHeaders.filters;

import cl.vicoga.webappHeaders.utils.ConnexionBDMysql;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConnexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try (Connection conn = ConnexionBDMysql.getConnection()) {

            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                servletRequest.setAttribute("conn",conn);
                filterChain.doFilter(servletRequest, servletResponse);
                conn.commit();
            } catch (SQLException se) {
                conn.rollback();
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, se.getMessage());
                se.printStackTrace();
            }
        } catch (SQLException e) {

        }
    }
}
