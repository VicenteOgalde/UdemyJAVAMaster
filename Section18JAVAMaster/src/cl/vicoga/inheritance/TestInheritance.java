package cl.vicoga.inheritance;

public class TestInheritance {
    public static void main(String[] args) {

        Student student = new Student("st1");

        student.setSchool("U 26");

        InternationalStudent studentInt= new InternationalStudent("pete");

        studentInt.setCountry("UK");


        Teacher teacher = new Teacher("tc1");


        Class stInt= studentInt.getClass();
        while (stInt.getSuperclass()!=null){

            System.out.println("child class: "+stInt.getClass().getName()+
                    " class father: "+stInt.getSuperclass().getName());

            stInt=stInt.getSuperclass();
        }




    }
}
