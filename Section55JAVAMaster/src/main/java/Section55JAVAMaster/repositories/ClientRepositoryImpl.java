package Section55JAVAMaster.repositories;

import Section55JAVAMaster.entity.Client;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClientRepositoryImpl implements CrudRepository<Client>{
    private EntityManager em;

    public ClientRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("select c from Client c",Client.class).getResultList();
    }

    @Override
    public Client findById(Long id) {
        return em.find(Client.class,id);
    }

    @Override
    public void save(Client client) {
        if(client.getId()==null) {
            em.persist(client);
        }else if(client.getId()>0){
            em.merge(client);
        }
    }

    @Override
    public void delete(Long id) {

        em.remove(findById(id));
    }
}
