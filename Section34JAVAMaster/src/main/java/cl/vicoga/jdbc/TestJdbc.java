package cl.vicoga.jdbc;

import cl.vicoga.jdbc.util.ConnectionDB;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) {


        try (Connection  conn = ConnectionDB.getConn();
             Statement  statement= conn.createStatement();
             ResultSet    resultSet= statement.executeQuery("select * from product")){


            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+" | ");
                System.out.print(resultSet.getString(2)+" | ");
                System.out.print(resultSet.getString(3)+" | ");
                System.out.print(resultSet.getString(4)+" | ");
                System.out.println(resultSet.getString(5));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
