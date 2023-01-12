package cl.vicoga.recursion.model;

import java.util.ArrayList;
import java.util.List;

public class Component {

    private String name;
    private List<Component> sons;

    public Component() {
        this.sons= new ArrayList<>();
    }

    public Component(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Component> getSons() {
        return sons;
    }

    public void setSons(List<Component> sons) {
        this.sons = sons;
    }

    public Component addSon(Component component){
        this.sons.add(component);
        return this;
    }

    public boolean hasSons(){
        return !this.sons.isEmpty();
    }
}
