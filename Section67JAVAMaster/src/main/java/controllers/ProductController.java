package controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import models.Product;

import java.util.Arrays;
import java.util.List;

@Model
public class ProductController {

    @Model
    @Produces
    public String title(){
        return "Hello World From JSF";
    }
    @RequestScoped
    @Named("product-list")
    @Produces
    public List<Product> findAll(){
        return Arrays.asList(new Product("apple"),new Product("orange"),
                new Product("pear"),
                new Product("tomato"),
                new Product("lettuce"));
    }

}
