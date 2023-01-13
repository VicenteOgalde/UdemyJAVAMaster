package cl.vicoga.desingpatterns.factory.product;

import cl.vicoga.desingpatterns.factory.ProductPizza;

public class PizzaVeggieNY extends ProductPizza {

    public PizzaVeggieNY() {
        super();
        this.name="Pizza Veggie";
        this.dough="Integral dough";
        this.sauce="tomato sauce";
        addIngredient("Vegan cheese")
                .addIngredient("tomato")
                .addIngredient("olive")
                .addIngredient("eggplant");



    }

    @Override
    public void cooking() {
        System.out.println("cook for 25 min, at 150C");
    }

    @Override
    public void cut() {

        System.out.println("cut on square shape");
    }
}
