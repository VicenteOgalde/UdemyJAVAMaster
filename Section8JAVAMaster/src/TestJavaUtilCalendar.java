import java.util.Calendar;
import java.util.Date;

public class TestJavaUtilCalendar {
    public static void main(String[] args) {

        // get an instance of calendar abstract class
        Calendar calendar= Calendar.getInstance();
        calendar.set(1999,Calendar.APRIL,22);

        Date date = calendar.getTime();

        System.out.println(date);
    }
}
