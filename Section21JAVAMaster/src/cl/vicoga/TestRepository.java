package cl.vicoga;

import cl.vicoga.model.Client;
import cl.vicoga.repository.*;

import java.util.List;

public class TestRepository {
    public static void main(String[] args) {

        CrudRepository rep = new ClientListRepository();

        rep.createClient(new Client("cli10"));
        rep.createClient(new Client("cli21"));
        rep.createClient(new Client("cli3"));
        rep.createClient(new Client("cli8"));

        List<Client> clients= rep.findAll();
        clients.forEach(System.out::println);

        System.out.println();

        clients=((PagingRepository)rep).findAllPaged(2,4);
        clients.forEach(System.out::println);

        System.out.println();

        ((SortRepository)rep).findAllSorted("name", Direction.DESC).forEach(System.out::println);


        System.out.println();

        Client c=rep.findById(1);
        c.setName("cli U10");
        rep.updateClient(c);
        rep.findAll().forEach(System.out::println);

        System.out.println();

        rep.deleteClientById(1);

        rep.findAll().forEach(System.out::println);





    }
}
