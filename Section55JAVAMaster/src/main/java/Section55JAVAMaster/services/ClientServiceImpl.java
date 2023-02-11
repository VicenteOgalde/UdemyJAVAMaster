package Section55JAVAMaster.services;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.repositories.ClientRepositoryImpl;
import Section55JAVAMaster.repositories.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private EntityManager em;
    private CrudRepository<Client> repository;

    public ClientServiceImpl(EntityManager em) {
        this.em = em;
        repository = new ClientRepositoryImpl(em);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public void save(Client client) {

        try {
            em.getTransaction().begin();
            repository.save(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            repository.delete(id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
