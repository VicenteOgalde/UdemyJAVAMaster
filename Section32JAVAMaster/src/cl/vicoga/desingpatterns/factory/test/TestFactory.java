package cl.vicoga.desingpatterns.factory.test;

import cl.vicoga.desingpatterns.factory.PizzaShopAbstractFactory;
import cl.vicoga.desingpatterns.factory.PizzaShopMiamiFactory;
import cl.vicoga.desingpatterns.factory.PizzaShopNewYorkFactory;
import cl.vicoga.desingpatterns.factory.ProductPizza;

public class TestFactory {
    public static void main(String[] args) {

        PizzaShopAbstractFactory ny = new PizzaShopNewYorkFactory();

        PizzaShopAbstractFactory mi= new PizzaShopMiamiFactory();

        ProductPizza pizza = ny.getPizza("pepperoni");

        System.out.println("tex order "+pizza.getName());

        pizza= ny.getPizza("veggie");

        System.out.println("tix order "+pizza.getName());


    }
}
