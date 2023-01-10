package cl.vicoga.optional.repository;

import cl.vicoga.optional.model.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerRepository implements Repository{

    private List<Computer> dataSource;

    public ComputerRepository() {
        this.dataSource=new ArrayList<>();
        this.dataSource.add(new Computer("pc1","pp1"));
        this.dataSource.add(new Computer("pc2","pp2"));
        this.dataSource.add(new Computer("pc3","pp5"));
        this.dataSource.add(new Computer("pc4","pp12"));
    }

    @Override
    public Optional<Computer> filter(String name) {
        return  dataSource.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
