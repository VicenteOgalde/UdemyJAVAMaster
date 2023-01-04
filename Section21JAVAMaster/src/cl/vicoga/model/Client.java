package cl.vicoga.model;

public class Client {

    private Integer id;
    private String name;
    private static Integer lastId;

    public Client() {
        this.id=++lastId;
    }

    public Client(String name) {
        this();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
