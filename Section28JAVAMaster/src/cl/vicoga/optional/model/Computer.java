package cl.vicoga.optional.model;

public class Computer {
    private String name;
    private String model;

    public Computer() {
    }

    public Computer(String name) {
        this.name = name;
    }

    public Computer(String name, String model) {
        this(name);
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
