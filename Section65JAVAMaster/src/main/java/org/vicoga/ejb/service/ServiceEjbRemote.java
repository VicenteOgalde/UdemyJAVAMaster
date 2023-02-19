package org.vicoga.ejb.service;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import org.vicoga.ejb.models.Product;

import java.util.List;

@Remote
public interface ServiceEjbRemote {

   String greet(String name);
   List<Product> findAll();
   Product create(Product product);
}
