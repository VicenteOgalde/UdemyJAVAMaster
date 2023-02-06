package cl.vicoga.webappHeaders.service;

import cl.vicoga.webappHeaders.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    void delete(Long id);
}
