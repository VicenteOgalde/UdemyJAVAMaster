package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientListRepository implements CrudRepository,SortRepository,PagingRepository{

    private List<Client> clients;

    public ClientListRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public List<Client> findAll() {
        return this.clients;
    }

    @Override
    public Client findById(Integer id) {
        Client cli=null;
        for (Client c:this.clients) {
            if(c.getId().equals(id)){
                cli=c;
            }
        }

        return cli;
    }

    @Override
    public void createClient(Client client) {
        this.clients.add(client);

    }

    @Override
    public void updateClient(Client client) {
        Client c= this.findById(client.getId());
        c.setName(client.getName());

    }

    @Override
    public void deleteClientById(Integer id) {
        this.clients.remove(this.findById(id));

    }

    @Override
    public List<Client> findAllPaged(int offset, int limit) {
     

        return this.clients.subList(offset,limit);
    }

    @Override
    public List<Client> findAllSorted(String field, Direction direction) {

        List<Client> sortList=this.clients;
        sortList.sort(new Comparator<Client>() {
            int res=0;
            @Override
            public int compare(Client a, Client b) {

                if(direction.equals(Direction.ASC)){
                    switch (field) {
                        case "id":
                            res = a.getId().compareTo(b.getId());

                        case "name":
                            res = a.getName().compareTo(b.getName());
                    }

                } else if (direction.equals(Direction.DESC)) {
                    switch (field) {
                        case "id":
                            res = b.getId().compareTo(a.getId());

                        case "name":
                            res = b.getName().compareTo(a.getName());
                    }
                }
                return res;
            }
        });
        return sortList;

    }
}
