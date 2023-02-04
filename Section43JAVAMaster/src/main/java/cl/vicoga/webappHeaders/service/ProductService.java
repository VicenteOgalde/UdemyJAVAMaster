package cl.vicoga.webappHeaders.service;

import cl.vicoga.webappHeaders.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
}
