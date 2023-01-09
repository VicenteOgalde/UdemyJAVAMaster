package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.Optional;
import java.util.stream.Stream;

public class TestStreamFilterEmpty {

    public static void main(String[] args) {


        Long names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt","","")
               .filter(n -> !n.isEmpty()).count();

        System.out.println(names);












    }

}
