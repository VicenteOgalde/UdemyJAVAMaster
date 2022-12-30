package cl.vicoga.inheritance;

public class TestInheritanceConstructor {
    public static void main(String[] args) {

        Student student = new Student("st1",25,"u 25");
        


        InternationalStudent studentInt= new InternationalStudent("pete");

        studentInt.setCountry("UK");


        Teacher teacher = new Teacher("tc1");

        print(student);
        System.out.println("-------------------");
        print(studentInt);








    }
    public static void print(Person person){
        System.out.println("person.getName() = " + person.getName());
        System.out.println("person.getAge() = " + person.getAge());
        if(person instanceof Student){
            System.out.println("((Student) person).getSchool() = " + ((Student) person).getSchool());
            if(person instanceof InternationalStudent){
                System.out.println("((InternationalStudent) person).getCountry() = " + ((InternationalStudent) person).getCountry());
            }
        }
    }
}
