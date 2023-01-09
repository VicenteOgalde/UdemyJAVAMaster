package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.stream.Stream;

public class TestStreamFilterAnyMatch {

    public static void main(String[] args) {


        Boolean b=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt")

                .map(String::toUpperCase)
                .map(n-> new User(n.split(" ")[0],n.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(u->u.getName().startsWith("TA"));

        
        //names.forEach(System.out::println);



        System.out.println(b);











    }

}
