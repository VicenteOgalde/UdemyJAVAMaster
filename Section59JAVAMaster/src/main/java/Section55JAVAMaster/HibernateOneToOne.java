package Section55JAVAMaster;

import Section55JAVAMaster.entity.Address;
import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.entity.DetailClient;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateOneToOne {
    public static void main(String[] args) {



        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Client c= new Client("lun7789","sol7789");
            c.setPaymentMethod("credit");

            em.persist(c);

            DetailClient clientDT= new DetailClient(true,50050L);
            clientDT.setClient(c);
            em.persist(clientDT);
            System.out.println(c);


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
