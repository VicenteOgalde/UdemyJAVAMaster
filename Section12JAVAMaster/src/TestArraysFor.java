import java.util.Arrays;

public class TestArraysFor {
    public static void main(String[] args) {

        String [] products= new String [3];
        products[0]="car";
        products[1]="tv";
        products[2]="book";
        int [] numbers= new int [3];
        int length=numbers.length;
        for (int i=0;i<length;i++){
            numbers[i]=i+12;
            System.out.println(numbers[i]);
        }
        for (String p:products) {
            System.out.println(p);
        }






    }
}
