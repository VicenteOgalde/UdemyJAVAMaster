package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Client>clients=em.createQuery("select c from Client c").getResultList();
        clients.forEach(System.out::println);
        em.close();
    }
}
