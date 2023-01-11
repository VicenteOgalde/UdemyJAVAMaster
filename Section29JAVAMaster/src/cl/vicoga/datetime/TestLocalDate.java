package cl.vicoga.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestLocalDate {
    public static void main(String[] args) {

        LocalDate actualDate = LocalDate.now();

        System.out.println("actualDate = " + actualDate);
        
        actualDate=LocalDate.of(2020,1,25);

        System.out.println("actualDate = " + actualDate);

        actualDate = LocalDate.parse("2020-02-01");

        System.out.println("actualDate = " + actualDate);

        LocalDate tDay = LocalDate.now().plusDays(1);

        System.out.println("tDay = " + tDay);
        
        LocalDate lastM= LocalDate.now().minusMonths(1);

        System.out.println("lastM = " + lastM);

        DayOfWeek dw = LocalDate.parse("2021-08-06").getDayOfWeek();

        System.out.println("dw = " + dw);
        
    }
}
