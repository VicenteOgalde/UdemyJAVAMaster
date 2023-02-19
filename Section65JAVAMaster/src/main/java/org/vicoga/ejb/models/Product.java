package org.vicoga.ejb.models;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    static final long serialVersionUID = 42146546L;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
