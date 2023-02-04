package cl.vicoga.webappHeaders.models;

import java.util.Objects;

public class ItemCar {
    private int numberOfItems;
    private Product product;


    public ItemCar(int numberOfItems, Product product) {

        this.numberOfItems = numberOfItems;
        this.product = product;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public int getTotal(){
        return numberOfItems*this.product.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCar itemCar = (ItemCar) o;
        return Objects.equals(product.getId(), itemCar.product.getId())
                && Objects.equals(product.getName(), itemCar.product.getName()) ;
    }


}
