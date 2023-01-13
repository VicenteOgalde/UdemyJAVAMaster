package cl.vicoga.desingpatterns.factory.product;

import cl.vicoga.desingpatterns.factory.ProductPizza;

public class PizzaPepperoniNY extends ProductPizza {

    public PizzaPepperoniNY() {
        super();
        this.name="Pizza pepperoni NY";
        this.dough="thin stone dough";
        this.sauce="tomato sauce";
        addIngredient("mozzarella cheese")
                .addIngredient("Extra Pepperoni")
                .addIngredient("olive");
    }

    @Override
    public void cooking() {

        System.out.println("cook for 20 min at 200c");
    }

    @Override
    public void cut() {

        System.out.println("cut pizza on triangle shape");
    }
}
