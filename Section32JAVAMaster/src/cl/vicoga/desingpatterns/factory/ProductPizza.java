package cl.vicoga.desingpatterns.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductPizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> ingredients;

    public ProductPizza() {
        this.ingredients= new ArrayList<>();

    }

    public void prepare(){
        System.out.println("preparing "+name);
        System.out.println("selecting the dough "+dough);
        System.out.println("selecting the sauce "+sauce);
        System.out.println("putting ingredients: ");
        this.ingredients.forEach(System.out::println);
    }

    public void packing(){
        System.out.println("pack the pizza");
    }
    abstract public void cooking();
    abstract public void cut();

    @Override
    public String toString() {
        return "ProductPizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
