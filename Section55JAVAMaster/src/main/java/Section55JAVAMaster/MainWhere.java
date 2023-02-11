package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class MainWhere {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query =em.createQuery("select c from Client c where c.paymentMethod=?1",Client.class);
        query.setParameter(1,"debit");
        List<Client>clients= query.getResultList();
        System.out.println(clients);
        Client c2= em.find(Client.class,1l);
        System.out.println(c2);
        em.close();
    }
}
