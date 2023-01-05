package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.List;

public interface SortRepository<T> {

    List<T> findAllSorted(String field,Direction direction);

}
