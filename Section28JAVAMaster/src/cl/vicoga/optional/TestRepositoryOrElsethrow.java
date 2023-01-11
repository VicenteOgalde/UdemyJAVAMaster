package cl.vicoga.optional;

import cl.vicoga.optional.model.Computer;
import cl.vicoga.optional.repository.ComputerRepository;
import cl.vicoga.optional.repository.Repository;

import java.util.Optional;

public class TestRepositoryOrElsethrow {
    public static void main(String[] args){


        Repository<Computer> computers = new ComputerRepository();
        
       Computer c= computers.filter("pc2")
                .orElseThrow();

        System.out.println(c);

        String ext= Optional.ofNullable("document.pdf")
                .filter(a->a.contains("."))
                .map(a->a.substring(a.lastIndexOf('.')+1))
                .orElseThrow();

        System.out.println(ext);







    }
    public static Computer defaultValue(){
        System.out.println("obtain value ");
        return new Computer("xxx","000");
    }
}
