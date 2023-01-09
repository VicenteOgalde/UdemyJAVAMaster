package cl.vicoga.api.stream.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamMap {

    public static void main(String[] args) {


        Stream<String> names=Stream.of("tex","tax","tix","tux")
                .peek(System.out::println)
                .map(String::toUpperCase);

        //names.forEach(System.out::println);

        List<String> l= names.collect(Collectors.toList());








    }

}
