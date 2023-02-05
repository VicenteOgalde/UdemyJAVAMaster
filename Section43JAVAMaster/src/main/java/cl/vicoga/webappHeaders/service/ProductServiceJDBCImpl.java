package cl.vicoga.webappHeaders.service;

import cl.vicoga.webappHeaders.models.Product;
import cl.vicoga.webappHeaders.repositories.ProductRepositoryImpl;
import cl.vicoga.webappHeaders.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceJDBCImpl implements ProductService{
    private ProductRepositoryImpl repository;

    public ProductServiceJDBCImpl(Connection conn) {
        this.repository= new ProductRepositoryImpl(conn);
    }

    @Override
    public List<Product> findAll() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            return Optional.ofNullable(repository.findById(id));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(),e.getCause());
        }
    }
}
