package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.entity.Invoice;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateOneToManyBidirectionalFind {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Client c= em.find(Client.class,1L);


            Invoice i2= new Invoice("office buy23",11100L);
            Invoice i= new Invoice("office buy24",11100L);
            c.addInvoice(i);
            c.addInvoice(i2);


       //     em.merge(c);

            em.getTransaction().commit();
            System.out.println(c);


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
