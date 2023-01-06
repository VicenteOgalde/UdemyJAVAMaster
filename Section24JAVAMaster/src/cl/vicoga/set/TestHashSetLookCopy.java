package cl.vicoga.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestHashSetLookCopy {
    public static void main(String[] args) {

        String[] fish={"salmon", "fish","tuna","fish"};

        Set<String> unique= new HashSet<>();

        for(String s:fish){
            if(!unique.add(s)){
                System.out.println("duplicate element "+s);
            }
        }




    }
}
