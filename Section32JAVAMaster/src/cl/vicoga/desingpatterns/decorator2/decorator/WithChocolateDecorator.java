package cl.vicoga.desingpatterns.decorator2.decorator;

import cl.vicoga.desingpatterns.decorator2.Decorable;

public class WithChocolateDecorator extends CoffeeDecorator{
    public WithChocolateDecorator(Decorable coffee) {
        super(coffee);
    }

    @Override
    public float getBasePrice() {
        return coffee.getBasePrice()+4.5f;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients()+"+ chocolate";
    }
}
