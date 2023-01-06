package cl.vicoga.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {


        Set<String> ts= new TreeSet<>(Comparator.reverseOrder());

        ts.add("one");
        ts.add("two");
        ts.add("one");
        ts.add("three");
        ts.add("five");

        System.out.println(ts);

        Set<Integer> ts2= new TreeSet<>((a,b)->b.compareTo(a));

        ts2.add(1);
        ts2.add(5);
        ts2.add(2);
        ts2.add(4);
        ts2.add(2);

        System.out.println(ts2);

    }

}
