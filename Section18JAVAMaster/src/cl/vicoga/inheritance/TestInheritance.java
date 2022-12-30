package cl.vicoga.inheritance;

public class TestInheritance {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("st1");
        student.setSchool("U 26");

        InternationalStudent studentInt= new InternationalStudent();
        studentInt.setName("pete");
        studentInt.setCountry("UK");


        Teacher teacher = new Teacher();
        teacher.setName("tc1");

        Class stInt= studentInt.getClass();
        while (stInt.getSuperclass()!=null){

            System.out.println("child class: "+stInt.getClass().getName()+
                    " class father: "+stInt.getSuperclass().getName());

            stInt=stInt.getSuperclass();
        }




    }
}
