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
            ResultSet rs=st.executeQuery("select * from products")) {

            while (rs.next()) {

                products.add(mapResulSetToProduct(rs));

            }
        }

        return products;
    }



    @Override
    public Product findById(Long id) throws SQLException {

        try(PreparedStatement ps= conn.prepareStatement("select * from products where" +
                " products.id=?")){
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) return mapResulSetToProduct(rs);

        }

        return null;
    }

    @Override
    public void save(Product product) throws SQLException {
        String sql;
        if(product.getId()!=null&&product.getId()>0){
            sql="update products set name=?,type=?,price=?  where id=?";
            try(PreparedStatement ps= conn.prepareStatement(sql)){
                ps.setString(1,product.getName());
                ps.setString(2,product.getType());
                ps.setInt(3,product.getPrice());
                ps.setLong(4,product.getId());
                ps.executeUpdate();
            }
        }else{
            sql="insert into products(id,name,type,price) values" +
                    "(?,?,?,?)";
            try(PreparedStatement ps= conn.prepareStatement(sql)){
                ps.setLong(1,product.getId());
                ps.setString(2,product.getName());
                ps.setString(3,product.getType());
                ps.setInt(4,product.getPrice());
                ps.executeUpdate();
            }
        }



    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql="delete * from products where products.id=?";
        try(PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setLong(1,id);
            ps.executeUpdate();
        }
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
