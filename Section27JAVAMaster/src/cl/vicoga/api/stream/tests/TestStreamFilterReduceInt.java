package cl.vicoga.api.stream.tests;

import java.util.stream.Stream;

public class TestStreamFilterReduceInt {

    public static void main(String[] args) {


        Stream<Integer> nameID=Stream
                .of(5,8,1,7)
                .distinct();

        Integer namI= nameID.reduce(0,(a,b)->a+b);
        System.out.println(namI);












    }

}
