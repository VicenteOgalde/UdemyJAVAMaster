package cl.vicoga.lambda;

import cl.vicoga.lambda.model.User;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestConsumer {

    public static void main(String[] args) {


        Consumer<Date> consumer= greet -> {

            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(f.format(greet));

             };
        consumer.accept(new Date());

        BiConsumer<String,Integer> biConsumer= (a,b)->{
            System.out.println("me name is "+a+" and me age is "+b);
        };

        biConsumer.accept("tex",56);

        Consumer<String> consumer1= System.out::println;

        consumer1.accept("hello....");

        List<String> names= Arrays.asList("tex","tax","tix","tox","tux");

        names.forEach(consumer1);

        BiConsumer<User,String> biConsumer1= User::setName;

        User user = new User();
        biConsumer1.accept(user,"tt");
        System.out.println(user.getName());

        Supplier<String> supplier = ()-> "hello";

        System.out.println(supplier.get());























    }

}
