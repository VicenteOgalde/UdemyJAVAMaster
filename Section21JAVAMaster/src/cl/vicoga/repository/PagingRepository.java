package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.List;

public interface PagingRepository<T> {
    List<T> findAllPaged(int offset,int limit);
}
