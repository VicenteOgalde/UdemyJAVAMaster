package cl.vicoga.api.stream.tests;

import java.util.stream.Stream;

public class TestStreamFilterDistinct {

    public static void main(String[] args) {


        Stream<String> names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt","tux tuxt","tux tuxt")
                .distinct();

        names.forEach(System.out::println);












    }

}
