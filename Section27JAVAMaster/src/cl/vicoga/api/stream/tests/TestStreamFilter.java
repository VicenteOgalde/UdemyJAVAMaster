package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamFilter {

    public static void main(String[] args) {


        Stream<User> names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt")
                .peek(System.out::println)
                .map(String::toUpperCase)
                .map(name-> new User(name.split(" ")[0],name.split(" ")[1]))
                .filter(u->u.getName().startsWith("TA"));


        //names.forEach(System.out::println);

        List<User> u= names.collect(Collectors.toList());

        u.forEach(user -> System.out.println(user.getName()+" "+user.getNick()));











    }

}
