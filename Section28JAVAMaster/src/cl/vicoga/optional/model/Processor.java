package cl.vicoga.optional.model;

public class Processor {
    private String name;
    private Maker maker;

    public Processor(String name, Maker maker) {
        this.name = name;
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }
}
