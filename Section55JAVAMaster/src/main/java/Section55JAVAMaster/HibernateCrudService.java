package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.services.ClientService;
import Section55JAVAMaster.services.ClientServiceImpl;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {
        EntityManager em= JpaUtil.getEntityManager();
        ClientService service= new ClientServiceImpl(em);

        System.out.println("-------------");
        System.out.println(service.findAll());
        System.out.println("-------------");
        System.out.println(service.findById(1L).get());
        System.out.println("-------------");
        service.save(new Client("user5",
                "us55","debit"));
        System.out.println(service.findAll());
        System.out.println("-------------");
        Optional<Client> op=service.findById(2L);
        op.ifPresent(o->o.setName("user0000"));
        op.ifPresent(service::save);
        System.out.println(service.findAll());
        System.out.println("-------------");
        service.delete(2L);
        System.out.println(service.findAll());

        em.close();
    }
}
