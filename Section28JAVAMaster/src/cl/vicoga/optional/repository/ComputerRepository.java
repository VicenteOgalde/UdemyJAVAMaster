package cl.vicoga.optional.repository;

import cl.vicoga.optional.model.Computer;
import cl.vicoga.optional.model.Maker;
import cl.vicoga.optional.model.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerRepository implements Repository{

    private List<Computer> dataSource;

    public ComputerRepository() {
        this.dataSource=new ArrayList<>();

        Processor p1= new Processor("i9",new Maker("Intel"));
        this.dataSource.add(new Computer("pc2","pp2",p1));
        this.dataSource.add(new Computer("pc1","pp1",p1));
        Processor p2= new Processor("ryzen 5", new Maker("AMD"));
        this.dataSource.add(new Computer("pc3","pp5",p2));
        this.dataSource.add(new Computer("pc4","pp12",p2));


    }

    @Override
    public Optional<Computer> filter(String name) {
        return  dataSource.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
