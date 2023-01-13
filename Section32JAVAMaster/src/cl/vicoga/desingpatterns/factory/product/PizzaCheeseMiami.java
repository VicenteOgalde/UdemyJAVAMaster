package cl.vicoga.desingpatterns.factory.product;

import cl.vicoga.desingpatterns.factory.ProductPizza;

public class PizzaCheeseMiami extends ProductPizza {


    public PizzaCheeseMiami() {
        super();
        this.name="Pizza extra cheese";
        this.dough="thin stone dough";
        this.sauce="white sauce";
        addIngredient("mozzarella cheese")
                .addIngredient("parmesan cheese")
                .addIngredient("olive")
                .addIngredient("pecorino cheese");
    }

    @Override
    public void cooking() {

        System.out.println("cook for 10 min at 250c");
    }

    @Override
    public void cut() {

        System.out.println("cut pizza on triangle shape");
    }
}
