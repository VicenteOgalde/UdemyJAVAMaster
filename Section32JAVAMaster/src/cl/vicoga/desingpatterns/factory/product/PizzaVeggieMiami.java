package cl.vicoga.desingpatterns.factory.product;

import cl.vicoga.desingpatterns.factory.ProductPizza;

public class PizzaVeggieMiami extends ProductPizza {

    public PizzaVeggieMiami() {
        super();
        this.name="Pizza Veggie";
        this.dough="Thin light dough";
        this.sauce="BBQ sauce light";
        addIngredient("Vegan cheese")
                .addIngredient("onion")
                .addIngredient("olive")
                .addIngredient("eggplant");

    }

    @Override
    public void cooking() {
        System.out.println("cook for 20 min, at 180C");
    }

    @Override
    public void cut() {

        System.out.println("cut on square shape");
    }
}
