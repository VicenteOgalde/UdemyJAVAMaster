package cl.vicoga.repository;



import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(Integer id);
    CrudRepository create(T t);
    void update(T t);
    void deleteById(Integer id);
}
