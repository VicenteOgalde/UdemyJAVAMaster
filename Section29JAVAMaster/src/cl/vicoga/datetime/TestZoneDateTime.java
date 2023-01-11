package cl.vicoga.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestZoneDateTime {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        ZoneId ny = ZoneId.of("America/New_York");

        ZonedDateTime nyZone=ZonedDateTime.of(now,ny);

        System.out.println("nyZone = " + nyZone);

        ZoneId madridZ= ZoneId.of("Europe/Madrid");
        
        ZonedDateTime  madridZone=nyZone.withZoneSameInstant(madridZ);

        System.out.println("madridZone = " + madridZone);

    }
}
