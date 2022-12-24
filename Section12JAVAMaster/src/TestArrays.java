import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {

        String [] products= new String [3];
        products[0]="car";
        products[1]="tv";
        products[2]="book";
        int [] numbers= new int [2];
        numbers[0]=15;
        numbers[1]=12;
        System.out.println("numbers[0]="+ numbers[0]);
        System.out.println("products[0] = " + products[0]);
        System.out.println("-----------------");
        Arrays.sort(numbers);
        Arrays.sort(products);
        System.out.println("numbers[0]="+ numbers[0]);
        System.out.println("products[0] = " + products[0]);



    }
}
