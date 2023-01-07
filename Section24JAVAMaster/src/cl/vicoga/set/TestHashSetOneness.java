package cl.vicoga.set;

import cl.vicoga.set.model.Student;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestHashSetOneness {
    public static void main(String[] args) {


        Set<Student> t= new HashSet<>();
        t.add(new Student("tex",5));
        t.add(new Student("tex",5));
        t.add(new Student("tix",4));
        t.add(new Student("tox",7));
        t.add(new Student("tax",3));

        System.out.println(t);

    }
}
