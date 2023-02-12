package Section55JAVAMaster;

import Section55JAVAMaster.dto.ClientDTO;
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

        lsClient.forEach(l->{
            System.out.println(l[0]);
            System.out.println(l[1]);
        });

        System.out.println("====personalized field List name and payment method====");

        lsClient=em.createQuery("select c,c.paymentMethod from Client c",Object[].class).getResultList();

        lsClient.forEach(e->{
            System.out.println(e[0]);
            System.out.println(e[1]);
        });
        System.out.println("====personalized object entity====");
        clients=em.createQuery("select new Client(c.name,c.surname) from " +
                "Client c",Client.class).getResultList();
        System.out.println(clients);

        System.out.println("====personalized object dto====");
        List<ClientDTO>clientsDTO=em.createQuery("select new Section55JAVAMaster.dto.ClientDTO(c.name,c.surname) from " +
                "Client c", ClientDTO.class).getResultList();
        System.out.println(clientsDTO);



        em.close();

    }
}
