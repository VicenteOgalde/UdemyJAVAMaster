package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.Optional;
import java.util.stream.Stream;

public class TestStreamFilterSingle2 {

    public static void main(String[] args) {


        User user=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt")

                .map(String::toUpperCase)
                .map(n-> new User(n.split(" ")[0],n.split(" ")[1]))
                .filter(u->u.getName().startsWith("TA"))
                .findFirst().get();

        
        //names.forEach(System.out::println);



        System.out.println(user.getName());











    }

}
