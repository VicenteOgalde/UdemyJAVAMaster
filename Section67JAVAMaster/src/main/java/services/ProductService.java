package services;

import jakarta.ejb.Local;
import models.Product;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);

}
