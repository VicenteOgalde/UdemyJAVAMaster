package cl.vicoga.list;

import cl.vicoga.set.model.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {
    public static void main(String[] args) {


        LinkedList<Student> t= new LinkedList<>();
        System.out.println(t+ ", size "+t.size());
        System.out.println(t+" is empty "+t.isEmpty());

        t.add(new Student("tex",5));
        t.add(new Student("tex",5));
        t.add(1,new Student("tix",4));
        t.add(new Student("tox",7));
        t.set(0,new Student("tax",3));

        System.out.println(t);

        t.addFirst(new Student("tt1",8));

        t.addLast(new Student("zz1",10));

        System.out.println(t);

        System.out.println("t.getFirst() = " + t.getFirst());

        System.out.println("t.getLast() = " + t.getLast());

        ListIterator<Student> li= t.listIterator();
        System.out.println();
        while (li.hasNext()){
            System.out.println(li.next());
        }
        System.out.println();
        while (li.hasPrevious()){
            Student s=li.previous();
            System.out.println(s);
        }












    }
}
