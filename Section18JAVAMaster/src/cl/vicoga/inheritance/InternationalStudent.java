package cl.vicoga.inheritance;

public class InternationalStudent extends Student{

    public InternationalStudent(String name) {
        super(name);
    }

    public InternationalStudent(String name, String country) {
        super(name);
        this.country = country;
    }

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String greet() {
        return super.greet()+" international";
    }
}
