package Section55JAVAMaster;

import Section55JAVAMaster.entity.Client;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateEdit {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {


            Long id= Long.valueOf(JOptionPane.showInputDialog("Type id of the client to update"));

            Client up=em.find(Client.class,id);
            String name= JOptionPane.showInputDialog("type new client name: "+up.getName());
            String surname= JOptionPane.showInputDialog("type new client surname: "+up.getSurname());
            String payment= JOptionPane.showInputDialog("type new client payment method: "+up.getPaymentMethod());


            em.getTransaction().begin();
            up.setName(name);
            up.setSurname(surname);
            up.setPaymentMethod(payment);
            em.merge(up);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
