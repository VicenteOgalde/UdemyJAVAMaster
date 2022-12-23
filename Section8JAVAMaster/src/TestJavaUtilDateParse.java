import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJavaUtilDateParse {
    public static void main(String[] args) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date= format.parse("2000-03-22");
            System.out.println(date);
            System.out.println(format.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
