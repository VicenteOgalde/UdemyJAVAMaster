package cl.vicoga;

import cl.vicoga.model.Client;
import cl.vicoga.model.Product;
import cl.vicoga.repository.AbstractListRepository;
import cl.vicoga.repository.Direction;
import cl.vicoga.repository.list.ClientListRepository;
import cl.vicoga.repository.list.ProductListRepository;

import java.util.List;

public class TestRepositoryProduct {
    public static void main(String[] args) {

        AbstractListRepository<Product> rep = new ProductListRepository();

        rep.create(new Product("pro1",2000))
                .create(new Product("pro25",25000))
        .create(new Product("pr256",5000))
        .create(new Product("prod569",1200));

        List<Product> products= rep.findAll();
        products.forEach(System.out::println);

        System.out.println();

        products=rep.findAllPaged(2,4);
        products.forEach(System.out::println);

        System.out.println();

        rep.findAllSorted("price", Direction.DESC).forEach(System.out::println);


        System.out.println();

        Product c=rep.findById(1);
        c.setDesc("cli U10");
        rep.update(c);
        rep.findAll().forEach(System.out::println);

        System.out.println();

        rep.deleteById(1);

        rep.findAll().forEach(System.out::println);





    }
}
