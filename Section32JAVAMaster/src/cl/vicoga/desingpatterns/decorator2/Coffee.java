package cl.vicoga.desingpatterns.decorator2;

public class Coffee implements Decorable {

    private float price;
    private String name;

    public Coffee(float price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public float getBasePrice() {
        return this.price;
    }

    @Override
    public String getIngredients() {
        return this.name;
    }


}
