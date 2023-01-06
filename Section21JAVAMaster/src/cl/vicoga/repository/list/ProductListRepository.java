package cl.vicoga.repository.list;

import cl.vicoga.model.Client;
import cl.vicoga.model.Product;
import cl.vicoga.repository.AbstractListRepository;
import cl.vicoga.repository.Direction;
import cl.vicoga.repository.exceptions.ReadDataException;

import java.util.Comparator;
import java.util.List;

public class ProductListRepository extends AbstractListRepository<Product> {




    @Override
    public List findAllSorted(String field, Direction direction) {
        List<Product> sortList=this.dataSource;
        sortList.sort(new Comparator<Product>() {
            int res=0;
            @Override
            public int compare(Product a, Product b) {

                if(direction.equals(Direction.ASC)){
                    switch (field) {
                        case "id":
                            res = a.getId().compareTo(b.getId());

                        case "desc":
                            res = a.getDesc().compareTo(b.getDesc());
                        case "price":
                            res = a.getPrice().compareTo(b.getPrice());
                    }

                } else if (direction.equals(Direction.DESC)) {
                    switch (field) {
                        case "id":
                            res = b.getId().compareTo(a.getId());

                        case "desc":
                            res = b.getDesc().compareTo(a.getDesc());
                        case "price":
                            res = a.getPrice().compareTo(b.getPrice());
                    }
                }
                return res;
            }
        });
        return sortList;



    }

    @Override
    public void update(Product product) throws ReadDataException {
        Product product1=findById(product.getId());
        product1.setDesc(product.getDesc());
        product1.setPrice(product.getPrice());

    }
}
