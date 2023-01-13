package cl.vicoga.desingpatterns.factory;

public abstract class PizzaShopAbstractFactory {

    public ProductPizza getPizza(String type){
        ProductPizza pizza = makePizza(type);
        System.out.println("Making a pizza -"+pizza.getName());
        pizza.prepare();
        pizza.cooking();
        pizza.cut();
        pizza.packing();
        return pizza;
    }

    abstract ProductPizza makePizza(String type);
}
