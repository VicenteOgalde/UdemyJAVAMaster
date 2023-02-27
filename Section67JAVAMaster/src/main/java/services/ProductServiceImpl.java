package services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import models.Product;
import repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductServiceImpl implements ProductService {

    @Inject
    CrudRepository<Product> repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            return Optional.of(repository.findById(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
