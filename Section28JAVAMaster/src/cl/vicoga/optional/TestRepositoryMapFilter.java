package cl.vicoga.optional;

import cl.vicoga.optional.model.Computer;
import cl.vicoga.optional.model.Maker;
import cl.vicoga.optional.repository.ComputerRepository;
import cl.vicoga.optional.repository.Repository;

public class TestRepositoryMapFilter {
    public static void main(String[] args) {


        Repository<Computer> computers = new ComputerRepository();
        
       Maker m= computers.filter("pc2")
               .map(c->c.getProcessor().getMaker())
               .filter(ma->ma.getName().equals("AMD"))
               .orElse(new Maker("000"));

        System.out.println(m.getName());



    }

}
