package cl.vicoga;

import cl.vicoga.model.Client;
import cl.vicoga.repository.*;
import cl.vicoga.repository.exceptions.DataException;
import cl.vicoga.repository.exceptions.ReadDataException;
import cl.vicoga.repository.list.ClientListRepository;

import java.util.List;

public class TestRepository {
    public static void main(String[] args) {

        try {
            AbstractListRepository<Client> rep = new ClientListRepository();

            rep.create(new Client("cli10"));
            rep.create(new Client("cli21"));
            rep.create(new Client("cli3"));
            rep.create(new Client("cli8"));

            List<Client> clients = rep.findAll();
            clients.forEach(System.out::println);

            System.out.println();

            clients = rep.findAllPaged(2, 4);
            clients.forEach(System.out::println);

            System.out.println();

            rep.findAllSorted("name", Direction.DESC).forEach(System.out::println);


            System.out.println();

            Client c = rep.findById(1);
            c.setName("cli U10");
            rep.update(c);
            rep.findAll().forEach(System.out::println);

            System.out.println();

            rep.deleteById(1);

            rep.findAll().forEach(System.out::println);
        }catch (ReadDataException re){
            System.out.println(re.getMessage());

        }catch (DataException de){
            System.out.println(de.getMessage());
        }




    }
}
