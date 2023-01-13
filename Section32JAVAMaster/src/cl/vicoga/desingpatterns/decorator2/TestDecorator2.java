package cl.vicoga.desingpatterns.decorator2;

import cl.vicoga.desingpatterns.decorator2.decorator.CoffeeDecorator;
import cl.vicoga.desingpatterns.decorator2.decorator.WithChocolateDecorator;
import cl.vicoga.desingpatterns.decorator2.decorator.WithCreamDecorator;
import cl.vicoga.desingpatterns.decorator2.decorator.WithMilkDecorator;

public class TestDecorator2 {


    public static void main(String[] args) {

        Decorable coffee = new Coffee(25,"coffee");

        System.out.println("coffee = " + coffee.getIngredients()+". price: "+coffee.getBasePrice());

        CoffeeDecorator coffeeMilk= new WithMilkDecorator(coffee);

        System.out.println("coffeeMilk = " + coffeeMilk.getIngredients());
        
        CoffeeDecorator coffeeChoc= new WithChocolateDecorator(coffeeMilk);

        System.out.println("coffeeChoc = " + coffeeChoc.getIngredients());
        
        CoffeeDecorator coffeeCream = new WithCreamDecorator(coffeeChoc);

        System.out.println("coffeeCream = " + coffeeCream.getIngredients());
        
    }
}
