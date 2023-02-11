package Section55JAVAMaster.services;

import Section55JAVAMaster.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    void save(Client client);
    void delete(Long id);
}
