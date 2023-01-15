package cl.vicoga.jdbc;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) {


        try (Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_project"
                ,"root","");
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
