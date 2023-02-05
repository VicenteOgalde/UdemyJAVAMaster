package cl.vicoga.webappHeaders.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository <T>{
    List<T> findAll() throws SQLException;
    T findById(Long id) throws SQLException;
    void save(T t) throws SQLException;
    void deleteById(Long id) throws SQLException;
}
