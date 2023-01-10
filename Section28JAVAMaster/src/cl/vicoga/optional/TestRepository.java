package cl.vicoga.optional;

import cl.vicoga.optional.model.Computer;
import cl.vicoga.optional.repository.ComputerRepository;
import cl.vicoga.optional.repository.Repository;

import java.util.Optional;

public class TestRepository {
    public static void main(String[] args) {


        Repository<Computer> computers = new ComputerRepository();
        
        Optional<Computer> c= computers.filter("ff");

        c.ifPresentOrElse(System.out::println,()-> System.out.println("is empty"));

        /*
        if(c.isPresent()) {
            System.out.println("c.getName() = " + c.get().getName());
        }else{
            System.out.println("is empty");
        }*/
    }
}
