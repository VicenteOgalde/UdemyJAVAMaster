package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateDelete {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            Long id= Long.valueOf(JOptionPane.showInputDialog("Type id of the client to delete"));

            em.getTransaction().begin();
            Client c= em.find(Client.class,id);
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
