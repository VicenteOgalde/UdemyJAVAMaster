package cl.vicoga.jdbc.util;

import java.sql.*;

public class ConnectionDB {

    private static String url="jdbc:mysql://localhost:3306/jsp_project",user="root",pass="";
    private static Connection conn = null;

    public static Connection getConn() throws SQLException {
        if (conn == null) {
            conn=DriverManager.getConnection(url,user,pass);
        }
        return conn;
    }
}
