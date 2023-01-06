package cl.vicoga.set;

import java.util.*;

public class TestHashSet {
    public static void main(String[] args) {

        Set<String> hs= new HashSet<>();

        hs.add("1st el");
        hs.add("2st");
        hs.add("3st");

        System.out.println(hs);

        System.out.println(hs.add("2st"));

        List<String> ls= new ArrayList<>(hs);
        Collections.sort(ls);

        System.out.println(ls);






    }
}
