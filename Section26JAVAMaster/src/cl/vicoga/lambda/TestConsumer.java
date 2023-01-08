package cl.vicoga.lambda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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























    }

}
