package org.vicoga.ejb.service;

import jakarta.ejb.Stateless;
import org.vicoga.ejb.models.Product;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceEjb implements ServiceEjbLocal {

    private int count;

    public String greet(String name) {
        count++;
        System.out.println(count);
        return "hello " + name;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("pen"));
        products.add(new Product("pin"));
        products.add(new Product("pon"));
        return products;
    }

    @Override
    public Product create(Product product) {
        Product p = new Product();
        p.setName(product.getName());
        return p;
    }

}
