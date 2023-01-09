package cl.vicoga.api.stream.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {

/*
        Stream<String> names=Stream.of("tex","tax","tix","tux");

        names.forEach(System.out::println);


        Stream<String> name= Stream.<String>builder().add("asd").add("qwe").add("123").add("zxc").build();

        name.forEach(e-> System.out.println("e = " + e));
*/
        List<Integer> numbers= new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(6);
        numbers.add(18);

        Stream<Integer> n=numbers.stream();





    }

}
