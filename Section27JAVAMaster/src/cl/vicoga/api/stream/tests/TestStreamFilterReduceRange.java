package cl.vicoga.api.stream.tests;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamFilterReduceRange {

    public static void main(String[] args) {


        IntStream nameID= IntStream.range(3,10).peek(System.out::println);


        IntSummaryStatistics stats = nameID.summaryStatistics();

        //Integer namI= nameID.sum();//nameID.reduce(0,(a,b)->a+b);

        System.out.println("max "+stats.getMax());
        System.out.println("average "+stats.getAverage());
        System.out.println("total elements "+stats.getCount());












    }

}
