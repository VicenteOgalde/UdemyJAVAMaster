package cl.vicoga.desingpatterns.decorator2.decorator;

import cl.vicoga.desingpatterns.decorator2.Decorable;

public abstract class CoffeeDecorator implements Decorable {

    protected Decorable coffee;

    public CoffeeDecorator(Decorable coffee) {
        this.coffee = coffee;

    }


}
