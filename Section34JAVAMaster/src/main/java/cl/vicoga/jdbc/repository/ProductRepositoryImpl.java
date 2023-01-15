package cl.vicoga.jdbc.repository;

import cl.vicoga.jdbc.model.Product;
import cl.vicoga.jdbc.util.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product>{

    private Connection getConnection() throws SQLException {
        return ConnectionDB.getConn();
    }

    @Override
    public List<Product> findAll() {

        List<Product> products=new ArrayList<>();

        try(Statement st = getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from product")){

            while (rs.next()){
                products.add(new Product(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("section"),
                        rs.getDouble("price"),
                        rs.getDate("date")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public Product findById() {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
