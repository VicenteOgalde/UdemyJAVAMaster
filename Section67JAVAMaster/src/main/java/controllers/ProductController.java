package controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.Product;
import services.ProductService;

import java.util.Arrays;
import java.util.List;

@Model
public class ProductController {

    @Inject
    private ProductService service;
    @Model
    @Produces
    public String title(){
        return "Hello World From JSF";
    }
    @RequestScoped
    @Named("product-list")
    @Produces
    public List<Product> findAll(){
        return service.findAll();
    }

}
