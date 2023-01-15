package cl.vicoga.jdbc.repository;

import java.util.List;

public interface Repository <T>{

    List<T> findAll();
    T findById();
    void save(T t);
    void update(T t);
    void delete(T t);

}
