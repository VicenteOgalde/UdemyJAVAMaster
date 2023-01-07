package cl.vicoga.set;

import cl.vicoga.set.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {


        List<Student> t= new ArrayList<>();
        System.out.println(t+ ", size "+t.size());
        System.out.println(t+" is empty "+t.isEmpty());

        t.add(new Student("tex",5));
        t.add(new Student("tex",5));
        t.add(1,new Student("tix",4));
        t.add(new Student("tox",7));
        t.set(0,new Student("tax",3));

        System.out.println(t);

        t.remove(new Student("tix",4));

        System.out.println(t);







    }
}
