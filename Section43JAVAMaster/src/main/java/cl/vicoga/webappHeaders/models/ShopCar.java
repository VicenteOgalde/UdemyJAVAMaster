package cl.vicoga.webappHeaders.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopCar {
    private List<ItemCar> shopCar;

    public ShopCar() {
        this.shopCar = new ArrayList<>();
    }

    public List<ItemCar> getShopCar() {
        return shopCar;
    }

    public ShopCar addItem(ItemCar item){
        if(this.shopCar.contains(item)){
            Optional<ItemCar>itemCarOp=this.shopCar.stream().filter(i->i.equals(item)).findFirst();
            itemCarOp.ifPresent(i->i.setNumberOfItems(i.getNumberOfItems()+item.getNumberOfItems()));
        }else {

            this.shopCar.add(item);
        }

        return this;
    }
    public int getTotal(){
        return this.shopCar.stream().mapToInt(ItemCar::getTotal).sum();
    }
}
