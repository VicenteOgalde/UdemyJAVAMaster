package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.Optional;
import java.util.stream.Stream;

public class TestStreamDistinctObj {

    public static void main(String[] args) {


        Stream<User> names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt","tux tuxt")
                .map(name-> new User(name.split(" ")[0],name.split(" ")[1]))
                .distinct();


        
        names.forEach(System.out::println);










    }

}
