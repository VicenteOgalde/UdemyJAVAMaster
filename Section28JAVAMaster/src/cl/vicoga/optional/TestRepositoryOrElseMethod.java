package cl.vicoga.optional;

import cl.vicoga.optional.model.Computer;
import cl.vicoga.optional.repository.ComputerRepository;
import cl.vicoga.optional.repository.Repository;

import java.util.Optional;

public class TestRepositoryOrElseMethod {
    public static void main(String[] args) {


        Repository<Computer> computers = new ComputerRepository();
        
       Computer c= computers.filter("pc2")
                .orElse(defaultValue());

        System.out.println(c);

        c=computers.filter("pc1").orElseGet(TestRepositoryOrElseMethod::defaultValue);

        System.out.println(c);




    }
    public static Computer defaultValue(){
        System.out.println("obtain value ");
        return new Computer("xxx","000");
    }
}
