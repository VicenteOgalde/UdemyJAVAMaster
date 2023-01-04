package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.ArrayList;
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
        return null;
    }

    @Override
    public List<Client> findAllSorted(String field, Direction direction) {
        return null;
    }
}
