package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.List;

public class HibernateQL {
    public static void main(String[] args) {

        EntityManager em= JpaUtil.getEntityManager();
        System.out.println("=====findAll====");
        List<Client>clients=em.createQuery("select c from Client c",Client.class).getResultList();
        clients.forEach(c-> System.out.println(c.getName()));

        System.out.println("====findById====");
        Client c=(Client) em.createQuery("select c from Client c where c.id=:idClient",Client.class).setParameter("idClient",1L)
                .getSingleResult();
        System.out.println(c);

        System.out.println("====justNameById====");
        String name= em.createQuery("select c.name from Client c where c.id=:id",String.class)
                .setParameter("id",3L)
                .getSingleResult();

        System.out.println(name);

        System.out.println("====personalized field====");
        Object[]objClient= em.createQuery("select c.id,c.name from Client c where id=:id",Object[].class)
                .setParameter("id",4L).getSingleResult();
        Arrays.asList(objClient).forEach(System.out::println);
        System.out.println("====personalized field List====");
        List<Object[]>lsClient=em.createQuery("select c.id,c.name from Client c",Object[].class).getResultList();

        lsClient.forEach(l->Arrays.asList(l).forEach(System.out::println));


    }
}
