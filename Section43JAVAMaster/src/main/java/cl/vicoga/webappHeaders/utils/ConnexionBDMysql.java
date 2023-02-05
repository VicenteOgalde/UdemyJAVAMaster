package cl.vicoga.webappHeaders.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDMysql {

    private static String url="jdbc:mysql://localhost:3306/udemyjava?serverTimezone=America/Santiago";
    private static String user="root";
    private static String pass="";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }


}
