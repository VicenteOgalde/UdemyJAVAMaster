package cl.vicoga.repository;



import cl.vicoga.model.GenericEntity;
import cl.vicoga.repository.exceptions.DataException;
import cl.vicoga.repository.exceptions.ReadDataException;

import java.util.ArrayList;

import java.util.List;

public abstract class AbstractListRepository<T extends GenericEntity> implements CrudRepository<T>,SortRepository<T>,PagingRepository<T>{

    protected List<T> dataSource;

    public AbstractListRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> findAll() {
        return this.dataSource;
    }

    @Override
    public T findById(Integer id) throws ReadDataException {
        if(id==null || id<=0){
            throw new ReadDataException("invalid id");
        }
        T cli=null;
        for (T c:this.dataSource) {
            if(c.getId().equals(id)){
                cli=c;
                break;
            }
        }

        return cli;
    }

    @Override
    public AbstractListRepository create(T t) {
        this.dataSource.add(t);
        return this;
    }

    @Override
    public void deleteById(Integer id) throws ReadDataException {
        this.dataSource.remove(this.findById(id));

    }

    @Override
    public List<T> findAllPaged(int offset, int limit) {
     

        return this.dataSource.subList(offset,limit);
    }

}
