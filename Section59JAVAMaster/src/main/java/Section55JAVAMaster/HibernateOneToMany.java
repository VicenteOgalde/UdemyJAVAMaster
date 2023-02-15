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
            Client c= new Client("lun","sol");
            c.setPaymentMethod("credit");
            Address a= new Address("fake street",23L);
            Address b= new Address("fake street",34L);
            c.setAddresses(Arrays.asList(a,b));
            em.persist(c);


            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            e.printStackTrace();
        }finally {
            em.close();
        }

    }
}
