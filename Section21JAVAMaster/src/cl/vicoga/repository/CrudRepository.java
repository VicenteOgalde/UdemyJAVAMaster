package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(Integer id);
    void createClient(T client);
    void updateClient(T client);
    void deleteClientById(Integer id);
}
