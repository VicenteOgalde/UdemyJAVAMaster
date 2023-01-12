package cl.vicoga.annotations;

import cl.vicoga.annotations.model.Product;
import cl.vicoga.annotations.utils.JsonSerializer;


import java.time.LocalDate;


public class TestAnnotation {
    public static void main(String[] args) {


        Product p  = new Product();
        p.setDate(LocalDate.now());
        p.setPrice(5000L);
        p.setName("tv led lg");






        System.out.println("json = " + JsonSerializer.turnToJson(p));
    }
}
