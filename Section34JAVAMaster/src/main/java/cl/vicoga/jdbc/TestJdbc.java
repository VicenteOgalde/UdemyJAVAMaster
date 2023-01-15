package cl.vicoga.jdbc;

import cl.vicoga.jdbc.model.Product;
import cl.vicoga.jdbc.repository.ProductRepositoryImpl;
import cl.vicoga.jdbc.repository.Repository;
import cl.vicoga.jdbc.util.ConnectionDB;

import java.sql.*;
import java.util.List;

public class TestJdbc {
    public static void main(String[] args) {


        try (Connection  conn = ConnectionDB.getConn()){

            Repository<Product> productRepository= new ProductRepositoryImpl();

            List<Product> products= productRepository.findAll();

            products.forEach(System.out::println);

            System.out.println(productRepository.findById("a28"));

            java.util.Date dat= new java.util.Date();
            Date date = new Date(dat.getTime());

            Product p = new Product("q12","printer","electronics",125,date);

            productRepository.save(p);
            System.out.println(productRepository.findAll());
            p.setPrice(320);
            productRepository.update(p);
            System.out.println(productRepository.findAll());

            productRepository.delete(p);
            System.out.println(productRepository.findAll());



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
