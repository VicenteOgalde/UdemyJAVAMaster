package cl.vicoga.datetime;

import java.time.LocalTime;

public class TestLocalDateTime {
    public static void main(String[] args) {

        LocalTime  now= LocalTime.now();

        System.out.println(now);

        System.out.println("now.getHour() = " + now.getHour());

        System.out.println("now.getMinute() = " + now.getMinute());

        LocalTime sixAndHalf = LocalTime.of(6,30);

        System.out.println("sixAndHalf = " + sixAndHalf);

        sixAndHalf = LocalTime.parse("06:30:02");

        System.out.println("sixAndHalf = " + sixAndHalf);
        
        
    }
}
