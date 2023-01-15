package cl.vicoga.jdbc.repository;

import cl.vicoga.jdbc.model.Product;
import cl.vicoga.jdbc.util.ConnectionDB;

import java.sql.*;
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
                products.add(mapProduct(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public Product findById(String id) {
        Product p=null;
        try(PreparedStatement pst = getConnection().prepareStatement("select * from product where id=?");
            ){
            pst.setString(1,id);
            try (ResultSet rs= pst.executeQuery()) {
                if (rs.next()) {
                    p = mapProduct(rs);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public void save(Product product) {

        try(PreparedStatement pst= getConnection()
                .prepareStatement("insert into product (id,name,section,price,date) " +
                        "values(?,?,?,?,?)")){
            pst.setString(1,product.getId());
            pst.setString(2,product.getName());
            pst.setString(3,product.getSection());
            pst.setDouble(4,product.getPrice());
            pst.setDate(5,new Date(product.getDate().getTime()));
            pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Product product) {
        try(PreparedStatement pst= getConnection()
                .prepareStatement("update product set name=?,section=?,price=?,date=? where id=?")){

            pst.setString(1,product.getName());
            pst.setString(2,product.getSection());
            pst.setDouble(3,product.getPrice());
            pst.setDate(4,new Date(product.getDate().getTime()));
            pst.setString(5,product.getId());
            pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {

        try(PreparedStatement pst= getConnection()
                .prepareStatement("delete from product where id=?")){
            pst.setString(1,product.getId());
            pst.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    private Product mapProduct(ResultSet rs) throws SQLException {
        Product p= new Product();
        p.setId(rs.getString("id"));
        p.setName(rs.getString("name"));
        p.setSection(rs.getString("section"));
        p.setDate(rs.getDate("date"));
        p.setPrice(rs.getDouble("price"));
        return p;
    }
}
