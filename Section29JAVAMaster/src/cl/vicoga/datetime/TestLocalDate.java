package cl.vicoga.datetime;

import java.time.LocalDate;

public class TestLocalDate {
    public static void main(String[] args) {

        LocalDate actualDate = LocalDate.now();

        System.out.println("actualDate = " + actualDate);
        
        actualDate=LocalDate.of(2020,1,25);

        System.out.println("actualDate = " + actualDate);


    }
}
