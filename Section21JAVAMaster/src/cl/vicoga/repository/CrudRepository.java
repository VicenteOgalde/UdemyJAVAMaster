package cl.vicoga.repository;



import cl.vicoga.repository.exceptions.DataException;
import cl.vicoga.repository.exceptions.ReadDataException;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(Integer id) throws DataException;
    CrudRepository create(T t);
    void update(T t) throws ReadDataException;
    void deleteById(Integer id)throws DataException;
}
