package cl.vicoga.repository.list;

import cl.vicoga.model.Client;
import cl.vicoga.repository.AbstractListRepository;
import cl.vicoga.repository.Direction;
import cl.vicoga.repository.exceptions.ReadDataException;

import java.util.Comparator;
import java.util.List;

public  class ClientListRepository extends AbstractListRepository<Client> {




    @Override
    public void update(Client client) throws ReadDataException {
        Client c= this.findById(client.getId());
        c.setName(client.getName());

    }



    @Override
    public List<Client> findAllSorted(String field, Direction direction) {

        List<Client> sortList=this.dataSource;
        sortList.sort(new Comparator<Client>() {
            int res=0;
            @Override
            public int compare(Client a, Client b) {

                if(direction.equals(Direction.ASC)){
                    switch (field) {
                        case "id":
                            res = a.getId().compareTo(b.getId());

                        case "name":
                            res = a.getName().compareTo(b.getName());
                    }

                } else if (direction.equals(Direction.DESC)) {
                    switch (field) {
                        case "id":
                            res = b.getId().compareTo(a.getId());

                        case "name":
                            res = b.getName().compareTo(a.getName());
                    }
                }
                return res;
            }
        });
        return sortList;

    }
}
