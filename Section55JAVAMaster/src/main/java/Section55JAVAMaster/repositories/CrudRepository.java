package Section55JAVAMaster.repositories;

import java.util.List;

public interface CrudRepository <T>{

    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(Long id);

}
