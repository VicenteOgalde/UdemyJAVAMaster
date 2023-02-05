package cl.vicoga.webappHeaders.repositories;

import cl.vicoga.webappHeaders.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product>{

    private Connection conn;

    public ProductRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products= new ArrayList<>();
        try(Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("select * from product")){

            while(rs.next()){
                mapResulSetToProduct(products, rs);

            }
        }

        return products;
    }

    private void mapResulSetToProduct(List<Product> products, ResultSet rs) throws SQLException {
        products.add(new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("type"),
                rs.getInt("price")
        ));
    }

    @Override
    public Product findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void save(Product product) throws SQLException {

    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }
}
