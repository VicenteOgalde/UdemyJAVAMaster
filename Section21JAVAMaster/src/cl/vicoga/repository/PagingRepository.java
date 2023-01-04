package cl.vicoga.repository;

import cl.vicoga.model.Client;

import java.util.List;

public interface PagingRepository {
    List<Client> findAllPaged(int offset,int limit);
}
