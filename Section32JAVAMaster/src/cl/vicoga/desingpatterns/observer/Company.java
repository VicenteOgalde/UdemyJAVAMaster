package cl.vicoga.desingpatterns.observer;

public class Company extends Observable{
    private String name;
    private int price;

    public Company(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        notifyObservers();
    }
}
