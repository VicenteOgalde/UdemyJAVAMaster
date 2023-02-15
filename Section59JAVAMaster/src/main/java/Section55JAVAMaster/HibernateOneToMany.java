package Section55JAVAMaster;

import Section55JAVAMaster.entity.Address;
import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.entity.Invoice;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Arrays;

public class HibernateOneToMany {
    public static void main(String[] args) {



        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Client c= new Client("lun7","sol7");
            c.setPaymentMethod("credit");
            Address a= new Address("fake street7",23L);
            Address b= new Address("fake street7",34L);
            c.getAddresses().add(a);
            c.getAddresses().add(b);
            em.persist(c);


            em.getTransaction().commit();
            System.out.println(c);

            em.getTransaction().begin();
            c=em.find(Client.class,c.getId());

            c.getAddresses().remove(b);

            em.getTransaction().commit();

        }catch (Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();
        }finally {
            em.close();
        }

    }
}
