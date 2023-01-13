package cl.vicoga.desingpatterns.decorator2.decorator;

import cl.vicoga.desingpatterns.decorator2.Decorable;

public class WithMilkDecorator extends CoffeeDecorator{


    public WithMilkDecorator(Decorable coffee) {
        super(coffee);
    }

    @Override
    public float getBasePrice() {
        return coffee.getBasePrice()+5f;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients()+"+ milk";
    }
}
