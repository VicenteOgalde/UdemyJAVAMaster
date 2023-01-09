package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.stream.Stream;

public class TestStreamFilterCount {

    public static void main(String[] args) {


        Long b=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt")

                .map(String::toUpperCase)
                .map(n-> new User(n.split(" ")[0],n.split(" ")[1]))
                .peek(System.out::println)
                .count();

        
        //names.forEach(System.out::println);



        System.out.println(b);











    }

}
