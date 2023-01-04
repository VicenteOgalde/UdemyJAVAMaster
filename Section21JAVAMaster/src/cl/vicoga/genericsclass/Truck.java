package cl.vicoga.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Truck implements Iterable {

    private List objs;
    private int max;

    public Truck(int max) {
        this.max = max;
        this.objs= new ArrayList();
    }
    public void addObj(Object o){
        if(this.objs.size()<=max) {
            this.objs.add(o);
        }else {
            throw new RuntimeException("no more space");
        }
    }

    @Override
    public Iterator iterator() {
        return this.objs.iterator();
    }
}
