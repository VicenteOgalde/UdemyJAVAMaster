package cl.vicoga.map;

import java.util.*;

public class TestTreeMap {
    public static void main(String[] args) {

        Map<String,Object> person= new TreeMap<>(Comparator.comparing(String::length));

        person.put("name","tex");
        person.put("nick","t");
        person.put("age","55");

        Map<String,String> address= new TreeMap<>(Comparator.reverseOrder());
        address.put("country","USA");
        address.put("state","cali");
        address.put("city","ohio");

        person.put("address",address);

        System.out.println("person = " + person);




    }
}
