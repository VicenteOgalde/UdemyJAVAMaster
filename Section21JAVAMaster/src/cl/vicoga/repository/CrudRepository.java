package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.List;

public interface CrudRepository {

    List<Client> findAll();
    Client findById(Integer id);
    void createClient(Client client);
    void updateClient(Client client);
    void deleteClientById(Integer id);
}
