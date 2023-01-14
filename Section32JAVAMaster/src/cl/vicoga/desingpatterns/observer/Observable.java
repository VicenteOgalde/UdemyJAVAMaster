package cl.vicoga.desingpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    protected List<Observer> observers = new ArrayList<>();

    public Observable addObserver(Observer obs){
        this.observers.add(obs);
        return this;
    }
    public void deleteObserver(Observer obs){
        this.observers.remove(obs);
    }
    public void notifyObservers(){
       notifyObservers(null);
    }
    public void notifyObservers(Object obj){
        this.observers.forEach(o->o.update(this,obj));
    }

}
