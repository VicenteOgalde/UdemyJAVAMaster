package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCreate {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {


            String name= JOptionPane.showInputDialog("type client name");
            String surname= JOptionPane.showInputDialog("type client surname");
            String payment= JOptionPane.showInputDialog("type client payment method");


            em.getTransaction().begin();
            Client c= new Client(name,surname,payment);
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
