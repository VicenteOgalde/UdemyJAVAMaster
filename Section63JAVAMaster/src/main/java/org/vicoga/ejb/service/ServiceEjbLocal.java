package org.vicoga.ejb.service;

import jakarta.ejb.Local;
import org.vicoga.ejb.models.Product;

import java.util.List;

@Local
public interface ServiceEjbLocal {

   String greet(String name);
   List<Product> findAll();
   Product create(Product product);
}
