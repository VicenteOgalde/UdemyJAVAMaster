package cl.vicoga.api.stream.tests;

import cl.vicoga.api.stream.model.User;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamDistinctObjSum {

    public static void main(String[] args) {


        IntStream names=Stream
                .of("tex text","tax taxt","tix tixt","tux tuxt","tux tuxt")
                .map(name-> new User(name.split(" ")[0],name.split(" ")[1]))
                .distinct()
                .mapToInt(u->u.getName().length());


        IntSummaryStatistics stats = names.summaryStatistics();

        System.out.println("stats.getCount() = " + stats.getCount());
        System.out.println("stats.getMax() = " + stats.getMax());
        System.out.println("stats.getAverage() = " + stats.getAverage());










    }

}
