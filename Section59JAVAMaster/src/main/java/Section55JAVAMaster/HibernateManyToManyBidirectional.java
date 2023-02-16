package Section55JAVAMaster;

import Section55JAVAMaster.entity.Course;
import Section55JAVAMaster.entity.Student;
import Section55JAVAMaster.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateManyToManyBidirectional {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Student student1= new Student("crisis2","rock");
            Student student2= new Student("crisis2","pebble");

            Course course1=new Course("math22","tt");
            Course course2=new Course("lang22","pp");

            student1.addCourse(course1);
            student2.addCourse(course2);
            student2.addCourse(course1);

            em.persist(student1);
            em.persist(student2);


            em.getTransaction().commit();

            em.getTransaction().begin();

            Course c1=new Course("math2","tt");
            c1.setId(9L);
            student2.getCourses().remove(c1);
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
