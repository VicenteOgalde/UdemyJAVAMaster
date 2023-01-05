package cl.vicoga.model;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericEntity entity = (GenericEntity) o;
        return Objects.equals(this.id, entity.id);
    }
}
