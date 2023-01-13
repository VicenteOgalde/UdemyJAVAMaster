package cl.vicoga.desingpatterns.factory;

import cl.vicoga.desingpatterns.factory.product.PizzaCheeseMiami;
import cl.vicoga.desingpatterns.factory.product.PizzaVeggieMiami;

public class PizzaShopMiamiFactory extends PizzaShopAbstractFactory{


    @Override
    ProductPizza makePizza(String type) {
        ProductPizza pizza=null;
        switch (type){
            case "veggie":
                pizza= new PizzaVeggieMiami();
                break;
            case "cheese":
                pizza= new PizzaCheeseMiami();
        }


        return pizza;
    }
}
