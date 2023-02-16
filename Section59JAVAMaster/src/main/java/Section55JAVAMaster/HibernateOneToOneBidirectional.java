package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.entity.DetailClient;
import Section55JAVAMaster.entity.Invoice;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateOneToOneBidirectional {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Client c= new Client("asd","zxc");
            c.setPaymentMethod("debit");

            DetailClient detailClient= new DetailClient(true,5000L);

            detailClient.setClient(c);
            c.setDetailClient(detailClient);


            em.persist(c);
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
