package cl.vicoga.desingpatterns.factory;

import cl.vicoga.desingpatterns.factory.product.PizzaPepperoniNY;
import cl.vicoga.desingpatterns.factory.product.PizzaVeggieNY;

public class PizzaShopNewYorkFactory extends PizzaShopAbstractFactory{

    @Override
    ProductPizza makePizza(String type) {
        ProductPizza pizza= null;
        switch (type){
            case"veggie":
                pizza= new PizzaVeggieNY();
                break;
            case "pepperoni":
                pizza= new PizzaPepperoniNY();
        }

        return pizza;
    }
}
