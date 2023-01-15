package cl.vicoga.jdbc.model;

import java.util.Date;

public class Product {
    private String id,name,section;
    private double price;
    private Date date;

    public Product() {
    }

    public Product(String id, String name, String section, double price, Date date) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", section='" + section + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
