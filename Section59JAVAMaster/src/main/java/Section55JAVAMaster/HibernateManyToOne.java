package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.entity.Invoice;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateManyToOne {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Client c= new Client("sol","soli");
            c.setPaymentMethod("debit");
            em.persist(c);

            Invoice i= new Invoice("office buy",100L);
            i.setClient(c);
            em.persist(i);


            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();

            e.printStackTrace();
        }finally {
            em.close();
        }


    }
}
