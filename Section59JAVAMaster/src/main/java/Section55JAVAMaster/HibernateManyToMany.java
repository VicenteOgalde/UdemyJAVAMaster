package Section55JAVAMaster;

import Section55JAVAMaster.entity.*;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateManyToMany {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Student student1= new Student("cris","rock");
            Student student2= new Student("cris","pebble");

            Course course1=new Course("math","tt");
            Course course2=new Course("lang","pp");

            student1.getCourses().add(course1);
            student1.getCourses().add(course2);
            student2.getCourses().add(course1);
            student2.getCourses().add(course2);

            em.persist(student1);
            em.persist(student2);


            em.getTransaction().commit();
            System.out.println(student1);
            System.out.println(student2);
        }catch (Exception e){
            em.getTransaction().rollback();

            e.printStackTrace();
        }finally {
            em.close();
        }


    }
}
