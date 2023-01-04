package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.List;

public interface SortRepository {

    List<Client> findAllSorted(String field,Direction direction);

}
