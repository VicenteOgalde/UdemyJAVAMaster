package cl.vicoga.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {

        Map<String,String> person= new HashMap<>();

        person.put("name","tex");
        person.put("nick","t");
        person.put("age","55");

        System.out.println("person = " + person);

        String name = person.get("name");

        System.out.println("name = " + name);

        person.remove("nick");

        System.out.println("person = " + person);

        boolean b=person.containsKey("age");
        System.out.println("exist age key "+b);

        b=person.containsValue("55");
        System.out.println("exist 55 value "+b);

        Collection<String> values= person.values();

        System.out.println("values = " + values);

        Set<String> keys= person.keySet();

        keys.forEach(System.out::println);

        person.forEach((k,v)-> System.out.println("key: "+k+", value: "+v));






    }
}
