package cl.vicoga.api.stream.tests;

import java.util.stream.Stream;

public class TestStreamFilterReduce {

    public static void main(String[] args) {


        Stream<String> names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt","tux tuxt","tux tuxt")
                .distinct();

        String nam= names.reduce("Concat ->",(a,b)->a+", "+b);
        System.out.println(nam);












    }

}
