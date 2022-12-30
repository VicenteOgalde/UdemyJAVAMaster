package cl.vicoga.inheritance;

public class Student extends Person{
    private String school;
    private double grade;

    public Student(String name) {
        super(name);
    }

    public Student(String name, int age) {
        super(name, age);

    }

    public Student(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String greet(){
        return super.greet()+" from a student";
    }
}
