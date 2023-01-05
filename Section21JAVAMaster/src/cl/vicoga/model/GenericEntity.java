package cl.vicoga.model;

public class GenericEntity {


    protected Integer id;
    private static int lastId;

    public GenericEntity() {
        this.id=++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
