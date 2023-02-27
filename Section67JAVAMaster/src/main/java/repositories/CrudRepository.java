package repositories;

import java.util.List;

public interface CrudRepository <T>{

    List<T> findAll();
    T findById(Long id);
}
