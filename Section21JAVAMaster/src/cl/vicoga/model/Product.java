package cl.vicoga.model;

public class Product extends GenericEntity{

    private String desc;
    private Double price;


    public Product(String desc, double price) {
        super();
        this.desc = desc;
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "desc='" + desc + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}

