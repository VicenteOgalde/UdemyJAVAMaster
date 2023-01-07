package cl.vicoga.map;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {

        Map<String,String> person= new HashMap<>();

        person.put("name","tex");
        person.put("nick","t");
        person.put("age","55");

        System.out.println("person = " + person);

        String name = person.get("name");

        System.out.println("name = " + name);



    }
}
