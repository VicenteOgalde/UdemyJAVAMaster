package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamMap {

    public static void main(String[] args) {


        Stream<User> names=Stream.of("tex","tax","tix","tux")
                .peek(System.out::println)
                .map(String::toUpperCase).map(User::new);

        //names.forEach(System.out::println);

        List<User> u= names.collect(Collectors.toList());

        u.forEach(user -> System.out.println(user.getName()));











    }

}
