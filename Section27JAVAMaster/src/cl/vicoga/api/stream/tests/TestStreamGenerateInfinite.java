package cl.vicoga.api.stream.tests;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class TestStreamGenerateInfinite {
    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(1);

        Stream.generate(()->"hello "+count.getAndIncrement())
                .limit(20)
                .forEach(System.out::println);



    }
}
