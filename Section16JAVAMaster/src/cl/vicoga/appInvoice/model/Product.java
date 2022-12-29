package cl.vicoga.appInvoice.model;

public class Product {

    private int id;
    private static int lastId;
    private String name;
    private double price;

    public Product() {
        this.id=++lastId;
    }

    public Product(String name, double price) {
        this.id=++lastId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
