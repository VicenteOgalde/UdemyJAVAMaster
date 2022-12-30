package cl.vicoga.inheritance;

public class Teacher extends Person{

private String course;

    public Teacher(String name) {
        super(name);
    }

    public Teacher(String name, String course) {
        super(name);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
