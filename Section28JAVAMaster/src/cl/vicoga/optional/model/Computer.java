package cl.vicoga.optional.model;

public class Computer {
    private String name;
    private String model;

    private Processor processor;
    public Computer() {
    }

    public Computer(String name) {
        this.name = name;
    }

    public Computer(String name, String model) {
        this(name);
        this.model = model;
    }

    public Computer(String name, String model, Processor processor) {
        this(name, model);
        this.processor = processor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
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
