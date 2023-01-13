package cl.vicoga.desingpatterns.decorator2.decorator;

import cl.vicoga.desingpatterns.decorator2.Decorable;

public class WithCreamDecorator extends CoffeeDecorator{
    public WithCreamDecorator(Decorable coffee) {
        super(coffee);
    }

    @Override
    public float getBasePrice() {
        return coffee.getBasePrice()+3f;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients()+"+ cream";
    }
}
