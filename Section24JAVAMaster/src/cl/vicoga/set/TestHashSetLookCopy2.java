package cl.vicoga.set;

import java.util.HashSet;
import java.util.Set;

public class TestHashSetLookCopy2 {
    public static void main(String[] args) {

        String[] fish={"salmon", "fish","tuna","fish"};

        Set<String> unique= new HashSet<>();
        Set<String> copies= new HashSet<>();
        for(String s:fish){
            if(!unique.add(s)){
                System.out.println("duplicate element "+s);
                copies.add(s);
            }
        }
        System.out.println(unique);
        System.out.println(copies);




    }
}
