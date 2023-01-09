package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamFilterSingle {

    public static void main(String[] args) {


        Stream<User> names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt")
                .peek(System.out::println)
                .map(String::toUpperCase)
                .map(name-> new User(name.split(" ")[0],name.split(" ")[1]))
                .filter(u->u.getName().startsWith("TA"));

        
        //names.forEach(System.out::println);

        Optional<User> u= names.findFirst();

        System.out.println(u.get().getName());











    }

}
