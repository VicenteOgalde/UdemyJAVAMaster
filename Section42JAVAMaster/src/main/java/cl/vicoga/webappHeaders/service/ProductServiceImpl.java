package cl.vicoga.webappHeaders.service;

import cl.vicoga.webappHeaders.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    @Override
    public List<Product> findAll() {
        return Arrays.asList(new Product(1l,"tv","elect",550)
                ,new Product(5l,"saw","manual",32),
                new Product(8L,"smartphone","elect",555));
    }
}
