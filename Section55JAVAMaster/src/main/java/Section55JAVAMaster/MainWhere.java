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
        query.setParameter(1,"cash");
        Client c=(Client) query.getSingleResult();
        System.out.println(c);
        em.close();
    }
}
