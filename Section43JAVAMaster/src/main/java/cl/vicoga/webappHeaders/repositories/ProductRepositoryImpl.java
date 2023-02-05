package cl.vicoga.webappHeaders.repositories;

import cl.vicoga.webappHeaders.models.Product;

import java.sql.*;
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
            ResultSet rs=st.executeQuery("select * from product")) {

            while (rs.next()) {

                products.add(mapResulSetToProduct(rs));

            }
        }

        return products;
    }



    @Override
    public Product findById(Long id) throws SQLException {

        try(PreparedStatement ps= conn.prepareStatement("select * from product where" +
                " product.id=?")){
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) return mapResulSetToProduct(rs);

        }

        return null;
    }

    @Override
    public void save(Product product) throws SQLException {

    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }

    private Product mapResulSetToProduct(ResultSet rs) throws SQLException {
        return (new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("type"),
                rs.getInt("price")
        ));
    }
}
