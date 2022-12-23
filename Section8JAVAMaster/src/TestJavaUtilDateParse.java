import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestJavaUtilDateParse {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("type your date with this format 'yyyy-MM-dd' : ");

        try {
            Date date= format.parse(sc.next());
            System.out.println(date);
            System.out.println(format.format(date));

            Date date2= new Date();

            String result=date.after(date2)?"you are from the future":"you are from the past";

            System.out.println(result);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
